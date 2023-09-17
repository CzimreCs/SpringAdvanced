package com.gfa.springadvanced;

import com.gfa.springadvanced.models.Genre;
import com.gfa.springadvanced.models.Role;
import com.gfa.springadvanced.models.User;
import com.gfa.springadvanced.repositories.GenreRepository;
import com.gfa.springadvanced.repositories.RoleRepository;
import com.gfa.springadvanced.repositories.UserRepository;
import com.gfa.springadvanced.services.MovieService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringAdvancedApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringAdvancedApplication.class, args);
    }

    @Bean
    CommandLineRunner run(RoleRepository roleRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {

        return args -> {
            if (roleRepository.findByAuthority("ADMIN").isPresent()) {
                return;
            }
            Role adminRole = roleRepository.save(new Role("ADMIN"));
            roleRepository.save(new Role("USER"));
            List<Role> roles = new ArrayList<>();
            roles.add(adminRole);
            User admin = new User( "admin", passwordEncoder.encode("password"), "csabi@csabi.com", roles);
            userRepository.save(admin);


        };
    }
}

