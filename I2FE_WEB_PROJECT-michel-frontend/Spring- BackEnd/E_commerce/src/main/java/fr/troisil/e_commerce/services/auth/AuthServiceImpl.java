package fr.troisil.e_commerce.services.auth;

import fr.troisil.e_commerce.dto.SignupRequest;
import fr.troisil.e_commerce.dto.UserDto;
import fr.troisil.e_commerce.entity.User;
import fr.troisil.e_commerce.enums.UserRole;
import fr.troisil.e_commerce.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserDto createUser (SignupRequest signupRequest){

        User user = new User();

        user.setEmail(signupRequest.getEmail());
        user.setName(signupRequest.getName());
        user.setPassword(new BCryptPasswordEncoder().encode(signupRequest.getPassword()));
        user.setRole(UserRole.CUSTOMER);
        User createdUser = userRepository.save(user);

        UserDto userDto = new UserDto();
        userDto.setId(createdUser.getId());

        return userDto;
    }
    public Boolean hasUserWithEmail (String email){
        return userRepository.findFirstByEmail(email).isPresent();
    }

}
