package com.pm.authservice.service;

import com.pm.authservice.model.User;
import com.pm.authservice.repository.UserRepo;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserService  {
    @Autowired
    UserRepo userRepo;

    public Optional<User> findByEmail(@Email(message = "email should be a valid email address") @NotBlank(message = "email should not be blank") String email) {
        return userRepo.findByEmail(email);
    }
}
