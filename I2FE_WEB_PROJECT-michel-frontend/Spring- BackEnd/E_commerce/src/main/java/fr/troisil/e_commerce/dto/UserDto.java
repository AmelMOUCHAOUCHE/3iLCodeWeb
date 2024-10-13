package fr.troisil.e_commerce.dto;

import fr.troisil.e_commerce.enums.UserRole;
import lombok.Data;

@Data
public class UserDto {
    private Long id;

    private String email;

    private String name;

    private UserRole role;
}

