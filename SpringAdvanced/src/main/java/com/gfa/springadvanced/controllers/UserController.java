package com.gfa.springadvanced.controllers;

import com.gfa.springadvanced.models.User;
import com.gfa.springadvanced.models.dtos.RegistrationDTO;
import com.gfa.springadvanced.services.AuthenticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final AuthenticationService authenticationService;

    public UserController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @GetMapping("/api/login")
    public ResponseEntity<?> login() {

        return ResponseEntity.ok("adfsda");
    }

    @PostMapping("/api/registration")
    public ResponseEntity<?> register(@RequestBody RegistrationDTO registrationDTO) throws Exception {
        User newUser = new User();
        try {
            newUser = authenticationService.registerUser(registrationDTO.getUsername(),
                    registrationDTO.getPassword(), registrationDTO.getPasswordConfirmation(), registrationDTO.getEmail());
        } catch (Exception e) {
            return ResponseEntity.status(400).build();
        }


        return ResponseEntity.ok(newUser);
    }

    @GetMapping("/api/test")
    public String test() {
        return "test";
    }
}
