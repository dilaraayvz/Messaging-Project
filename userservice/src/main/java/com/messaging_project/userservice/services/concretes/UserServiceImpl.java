package com.messaging_project.userservice.services.concretes;

import com.messaging_project.userservice.entities.User;
import com.messaging_project.userservice.repositories.UserRepository;
import com.messaging_project.userservice.services.abstracts.UserService;
import com.messaging_project.userservice.services.dtos.request.UserAddRequest;
import com.messaging_project.userservice.services.dtos.request.UserUpdateRequest;
import com.messaging_project.userservice.services.dtos.response.UserAddResponse;
import com.messaging_project.userservice.services.dtos.response.UserGetByIdResponse;
import com.messaging_project.userservice.services.dtos.response.UserUpdateResponse;
import com.messaging_project.userservice.services.mappers.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;

    @Override
    public UserAddResponse addUser(UserAddRequest userAddRequest) {
        User user=userMapper.toEntity(userAddRequest);
        User savedUser=userRepository.save(user);
        return userMapper.toAddResponse(savedUser);
    }

    @Override
    public UserUpdateResponse updateUser(int userId, UserUpdateRequest userUpdateRequest) {
        return null;
    }

    @Override
    public UserGetByIdResponse getUserById(int userId) {
        return null;
    }

    @Override
    public List<UserGetByIdResponse> getAllUsers() {
        return null;
    }
}
