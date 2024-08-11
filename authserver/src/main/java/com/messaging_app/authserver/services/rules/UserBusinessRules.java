package com.messaging_app.authserver.services.rules;

import com.messaging_app.authserver.core.utils.types.BusinessException;
import com.messaging_app.authserver.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserBusinessRules {
    private final UserRepository userRepository;

    public void checkIfUserAlreadyExists(String email) {
        if (userRepository.existsByEmail(email)){
            throw new BusinessException("This email address already exists.");
        }
    }


    public void checkIfUserNotExists(String email) {
        if (!userRepository.existsByEmail(email)) {
            throw new BusinessException("User not found!");
        }
    }
}
