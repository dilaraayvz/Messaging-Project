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
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final UserBusinessRules userBusinessRules;


    @Override
    public UserAddResponse addUser(UserAddRequest userAddRequest) {
        // Check if email or username already exists
        userBusinessRules.checkIfEmailIsAlreadyExist(userAddRequest.getEmail());
        userBusinessRules.checkIfuserNameIsAlreadyExist(userAddRequest.getUserName());

        // DTO to Entity conversion
        User user = userMapper.toEntity(userAddRequest);

        // Save entity to database
        User savedUser = userRepository.save(user);

        // Entity to DTO conversion for response
        return userMapper.toAddResponse(savedUser);
    }

    @Override
    public UserUpdateResponse updateUser(int id, UserUpdateRequest userUpdateRequest) {
        // Check if user exists
        userBusinessRules.checkIfUserExist(id);

        // Find existing user by ID and update
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Update entity with new values from request
        userMapper.updateEntityFromRequest(userUpdateRequest, existingUser);

        // Save updated entity to database
        User updatedUser = userRepository.save(existingUser);

        // Convert to response DTO
        return userMapper.toUpdateResponse(updatedUser);
    }

    @Override
    public UserGetByIdResponse getUserById(int id) {
        // Check if user exists and retrieve user
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Convert found user to DTO
        return userMapper.toGetByIdResponse(user);
    }

    @Override
    public List<UserGetByIdResponse> getAllUsers() {
        // Retrieve all users
        List<User> users = userRepository.findAll();

        // Convert user list to response DTOs
        return users.stream()
                .map(userMapper::toGetByIdResponse)
                .collect(Collectors.toList());
    }
}