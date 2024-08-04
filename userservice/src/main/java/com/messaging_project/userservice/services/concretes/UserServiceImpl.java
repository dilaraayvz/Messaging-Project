package com.messaging_project.userservice.services.concretes;

import com.messaging_project.userservice.repositories.UserRepository;
import com.messaging_project.userservice.services.abstracts.UserService;
import com.messaging_project.userservice.services.dtos.request.UserCreate;
import com.messaging_project.userservice.services.dtos.request.UserUpdate;
import com.messaging_project.userservice.services.dtos.response.UserGet;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    @Override
    public UserGet createUser(UserCreate createUser) {
        return null;
    }

    @Override
    public UserGet updateUser(int id, UserUpdate createUser) {
        return null;
    }

    @Override
    public void deleteUser(int id) {

    }

    @Override
    public UserGet getUserById(int id) {
        return null;
    }
}
