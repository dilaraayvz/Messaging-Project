package com.messaging_project.userservice.services.abstracts;


import com.messaging_project.userservice.services.dtos.request.UserAddRequest;
import com.messaging_project.userservice.services.dtos.request.UserUpdateRequest;
import com.messaging_project.userservice.services.dtos.response.UserAddResponse;
import com.messaging_project.userservice.services.dtos.response.UserGetByIdResponse;
import com.messaging_project.userservice.services.dtos.response.UserUpdateResponse;

import java.util.List;

public interface UserService {
    UserAddResponse addUser(UserAddRequest userAddRequest);
    UserUpdateResponse updateUser(int id, UserUpdateRequest userUpdateRequest);
    UserGetByIdResponse getUserById(int id);
    List<UserGetByIdResponse> getAllUsers();
}
