package fr.troisil.e_commerce.services;

import fr.troisil.e_commerce.dto.Achat;
import fr.troisil.e_commerce.dto.AchatResponse;

public interface IPanierAchatService {

    AchatResponse passerCommande(Achat achat);

}
