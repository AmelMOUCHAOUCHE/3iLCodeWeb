package fr.troisil.e_commerce.controllers;


import fr.troisil.e_commerce.dto.Achat;
import fr.troisil.e_commerce.dto.AchatResponse;
import fr.troisil.e_commerce.services.IPanierAchatService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/commande")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class PanierAchatController {

    final private IPanierAchatService panierAchatService;

    @PostMapping("/add")
    public AchatResponse passerCommande(@RequestBody Achat achat) {

        return panierAchatService.passerCommande(achat);
    }
}
