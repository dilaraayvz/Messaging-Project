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
import com.messaging_project.userservice.services.rules.UserBusinessRules;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private UserMapper userMapper;
    private UserBusinessRules userBusinessRules;

    @Override
    public UserAddResponse addUser(UserAddRequest userAddRequest) {
        userBusinessRules.checkIfEmailIsAlreadyExist(userAddRequest.getEmail());
        userBusinessRules.checkIfuserNameIsAlreadyExist(userAddRequest.getUserName());

        User user = userMapper.toEntity(userAddRequest);
        User savedUser = userRepository.save(user);
        return userMapper.toAddResponse(savedUser);
    }

    @Override
    public UserUpdateResponse updateUser(int id, UserUpdateRequest userUpdateRequest) {
        userBusinessRules.checkIfUserExist(id);
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        userMapper.updateEntity(user, userUpdateRequest);
        user.setUpdatedDate(LocalDateTime.now());
        User updatedUser = userRepository.save(user);
        return userMapper.toUpdateResponse(updatedUser);
    }

    @Override
    public UserGetByIdResponse getUserById(int userId) {
        userBusinessRules.checkIfUserExist(userId);
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        return userMapper.toGetByIdResponse(user);
    }

    @Override
    public List<UserGetByIdResponse> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(userMapper::toGetByIdResponse).collect(Collectors.toList());
    }
}
