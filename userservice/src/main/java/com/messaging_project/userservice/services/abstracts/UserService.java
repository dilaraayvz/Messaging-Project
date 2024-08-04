package com.messaging_project.userservice.services.abstracts;

import com.messaging_project.userservice.services.dtos.request.UserCreate;
import com.messaging_project.userservice.services.dtos.request.UserUpdate;
import com.messaging_project.userservice.services.dtos.response.UserGet;

public interface UserService {
    UserGet createUser(UserCreate createUser);
    UserGet updateUser(int id, UserUpdate createUser);
    void deleteUser(int id);
    UserGet getUserById(int id);
}
