package com.messaging_app.authserver.services.abstracts;

import com.messaging_app.authserver.entities.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    void add(User user);
}
