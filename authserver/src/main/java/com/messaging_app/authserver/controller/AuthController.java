package com.messaging_app.authserver.controller;


import com.messaging_app.authserver.services.abstracts.AuthService;
import com.messaging_app.authserver.services.dtos.requests.LoginRequest;
import com.messaging_app.authserver.services.dtos.requests.RegisterRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    @PostMapping("/register")
    @PreAuthorize("permitAll()")  // Bu şekilde herkesin erişimine izin verilebilir
    public void register(@Valid @RequestBody RegisterRequest request){
        authService.register(request);
    }
    @PostMapping("/login")
    public String login(@Valid @RequestBody LoginRequest request){
        return authService.login(request);
    }
}