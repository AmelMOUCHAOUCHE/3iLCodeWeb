package fr.troisil.e_commerce.entity;

import fr.troisil.e_commerce.enums.UserRole;
import jakarta.persistence.*;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@Entity
@Data
@Table(name = "users")
@Getter
@Setter
@ToString

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;

    private String email;

    private String password;

    private String name;

    private String prenom;

    private UserRole role;


    @Lob
    @Column(columnDefinition = "Longblob")
    private byte[] photo;


    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }
}
