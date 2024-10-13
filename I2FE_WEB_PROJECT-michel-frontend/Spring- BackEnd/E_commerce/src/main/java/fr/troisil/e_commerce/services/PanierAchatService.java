package fr.troisil.e_commerce.services;

import fr.troisil.e_commerce.dto.Achat;
import fr.troisil.e_commerce.dto.AchatResponse;
import fr.troisil.e_commerce.entity.Commande;
import fr.troisil.e_commerce.entity.ElementPanier;
import fr.troisil.e_commerce.entity.User;
import fr.troisil.e_commerce.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PanierAchatService implements IPanierAchatService {

    final private UserRepository userRepository;


    @Override
    @Transactional
    public AchatResponse passerCommande(Achat achat) {
        // recuperer la commande du dto achat
        Commande commande = achat.getCommande();

        // generer un numero de suivi
        String numeroSuivi = genererNumeroSuiviCommande();
        commande.setNumeroSuiviCommande(numeroSuivi);

        // remplir la commande avec les elements du panier
        Set<ElementPanier> panierElements = achat.getCommandeElements();
        if(!achat.getCommandeElements().isEmpty()){
            panierElements.forEach(element -> {
                //commande.getPanierItems().add(element);
                commande.add(element);
            });
        }

        // relier l'utilisateur avec sa commande
        Utilisateur utilisateur = achat.getUtilisateur();

        // commande.setEmail(utilisateur.getEmail());

        //verifier si l'utilisateur existe deja
        String email = utilisateur.getEmail();

        Utilisateur utilisateurExistant = userRepository.findByEmail(email);

        if(utilisateurExistant != null){
            // si l'utilisateur existe deja, on le recupere pour l'utiliser
            utilisateur = utilisateurExistant;
        }

        utilisateur.addCommande(commande);


        // on MAJ le user avec sa commande
        userRepository.save(utilisateur);

        // retouner 'numeroSuivi'
        return new AchatResponse(numeroSuivi);
    }

    private String genererNumeroSuiviCommande() {

        // on va créer un numero de suivi aleatoire et unique
        return UUID.randomUUID().toString();
    }
}
