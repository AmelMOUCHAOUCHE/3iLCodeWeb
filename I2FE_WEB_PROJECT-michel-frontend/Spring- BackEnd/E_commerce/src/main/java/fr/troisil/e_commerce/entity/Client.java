package fr.troisil.e_commerce.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@DiscriminatorValue("CLIENT")
@Getter
@Setter
@NoArgsConstructor
public class Client extends User {

    private String adresse;
    private String telephone;

    // Vous pouvez ajouter d'autres attributs spécifiques aux clients ici
}