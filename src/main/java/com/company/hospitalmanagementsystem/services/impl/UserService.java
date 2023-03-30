package com.company.hospitalmanagementsystem.services.impl;

import com.company.hospitalmanagementsystem.models.UserEntity;
import com.company.hospitalmanagementsystem.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
private final UserRepo userRepo;
    public Optional<UserEntity> findByEmail(String username){
        System.out.println(username);
        if(!userRepo.findByEmail(username).isEmpty()) {
            return userRepo.findByEmail(username);
        }
        return Optional.empty();

    }
    public void saveUser(UserEntity user){
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        userRepo.save(user);

    }
}
