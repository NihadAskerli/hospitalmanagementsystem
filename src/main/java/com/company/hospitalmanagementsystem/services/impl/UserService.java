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
        if(userRepo.findByEmail(username)!=null) {
            return userRepo.findByEmail(username);
        }
        return Optional.empty();

    }
    public void saveUser(UserEntity user){
        String userPassword=new BCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword(userPassword);
        userRepo.save(user);

    }
}
