package com.gfa.springadvanced.services;

import com.gfa.springadvanced.models.Role;
import com.gfa.springadvanced.models.User;
import com.gfa.springadvanced.repositories.RoleRepository;
import com.gfa.springadvanced.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;


    @Autowired
    public AuthenticationServiceImpl(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;

        this.passwordEncoder = passwordEncoder;
    }




    @Override
    public User registerUser(String username, String password , String passwordConfirmation, String email) throws Exception {
        if (!password.equals(passwordConfirmation)) { throw new Exception("the two passwords don't match");}
        if (userRepository.existsByEmail(email)) { throw new Exception("E-mail is already in use.");}
        String encodedPassword = passwordEncoder.encode(password);
        Role userRole= roleRepository.findByAuthority("USER").get();
        List<Role> authorities = new ArrayList<>();
        authorities.add(userRole);
        return userRepository.save(new User(username, encodedPassword,email, authorities));

    }
}
