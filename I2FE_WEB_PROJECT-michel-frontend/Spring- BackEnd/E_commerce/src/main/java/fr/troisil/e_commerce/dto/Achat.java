package fr.troisil.e_commerce.dto;

import fr.troisil.e_commerce.entity.Commande;
import fr.troisil.e_commerce.entity.ElementPanier;
import fr.troisil.e_commerce.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Achat {
    private Utilisateur utilisateur;
    private Commande commande;
    private Set<ElementPanier> commandeElements = new HashSet<>();
}
