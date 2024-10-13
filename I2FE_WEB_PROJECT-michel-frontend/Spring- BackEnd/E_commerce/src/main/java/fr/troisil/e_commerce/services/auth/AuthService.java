package fr.troisil.e_commerce.services.auth;

import fr.troisil.e_commerce.dto.SignupRequest;
import fr.troisil.e_commerce.dto.UserDto;

public interface AuthService {

    UserDto createUser (SignupRequest signupRequest);

    Boolean hasUserWithEmail (String email);

}
