package com.messaging_app.authserver.services.abstracts;

import com.messaging_app.authserver.services.dtos.requests.LoginRequest;
import com.messaging_app.authserver.services.dtos.requests.RegisterRequest;

public interface AuthService {
    void register(RegisterRequest request);
    void login(LoginRequest loginRequest);
}
