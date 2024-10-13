package fr.troisil.e_commerce.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ElementPanier implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String imageUrl ;
    float prixUnitaire;

    int quantite;
    @JoinColumn(name = "Produit_id")
    Long numProd;

    @ManyToOne
    @JoinColumn(name = "Commande_id")
    private Commande commande;
}
