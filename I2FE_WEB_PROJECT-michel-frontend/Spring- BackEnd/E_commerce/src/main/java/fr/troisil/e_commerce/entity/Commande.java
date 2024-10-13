package fr.troisil.e_commerce.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Commande implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name = "Commande_id")
    Long id_commande;
//    String email_user;
    @Temporal(TemporalType.DATE )
    Date date_commande;

    double prixTotal = 0;
    int quantiteTotale =0;

    @ManyToOne
    Utilisateur utilisateur;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "commande")
    @JsonIgnore
    Set<ElementPanier> panierItems = new HashSet<>();

    String numeroSuiviCommande;


    // add a item to the panierItems customized method
    public void add(ElementPanier item) {

        // if the item is not null
        if(item != null) {
            // if the panierItems is null, initialize it
            if(panierItems == null) {
                // initialize the panierItems
                panierItems = new HashSet<>();
            }
            // add the item to the panierItems
            panierItems.add(item);
            // set the item's commande to this
            item.setCommande(this);
        }
    }

}
