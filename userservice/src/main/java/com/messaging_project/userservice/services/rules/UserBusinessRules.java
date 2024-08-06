package com.messaging_project.userservice.services.rules;

import com.messaging_project.userservice.repositories.UserRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Service
//@RequiredArgsConstructor
@Getter
@Setter
public class UserBusinessRules {
    private final UserRepository userRepository;

    public UserBusinessRules(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void checkIfUserExist(int id){
        if(!userRepository.existsById(id)){
            throw new RuntimeException("User does not exist.");
        }
    }
    public void checkIfEmailIsAlreadyExist(String eMail){
        if(userRepository.isUserExist(eMail)) {
            throw new RuntimeException("Email is already in use.");
        }
    }
    public void checkIfuserNameIsAlreadyExist(String userName){
        if(userRepository.isUserExist(userName)) {
            throw new RuntimeException("Username is already in use.");
        }
    }
}
