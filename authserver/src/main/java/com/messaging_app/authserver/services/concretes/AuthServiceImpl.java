package com.messaging_app.authserver.services.concretes;

import com.messaging_app.authserver.entities.User;
import com.messaging_app.authserver.services.abstracts.AuthService;
import com.messaging_app.authserver.services.abstracts.UserService;
import com.messaging_app.authserver.services.dtos.requests.LoginRequest;
import com.messaging_app.authserver.services.dtos.requests.RegisterRequest;
import com.messaging_app.authserver.services.mappers.UserMapper;
import com.messaging_app.authserver.services.rules.UserBusinessRules;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final PasswordEncoder passwordEncoder;
    private final UserService userService;
    private final UserBusinessRules userBusinessRules;
    @Override
    public void register(RegisterRequest request) {
        userBusinessRules.checkIfUserAlreadyExists(request.getEmail());
        User user = UserMapper.INSTANCE.userFromRegisterRequest(request);
        //şifre plain text yazılmamalı
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        userService.add(user);
    }

    @Override
    public String login(LoginRequest loginRequest) {
        return null;
    }
}
