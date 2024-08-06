package com.messaging_project.userservice.services.concretes;

import com.messaging_project.commonpackage.configuration.utils.mappers.ModelMapperService;
import com.messaging_project.userservice.entities.User;
import com.messaging_project.userservice.repositories.UserRepository;
import com.messaging_project.userservice.services.abstracts.UserService;
import com.messaging_project.userservice.services.dtos.request.UserAddRequest;
import com.messaging_project.userservice.services.dtos.request.UserUpdateRequest;
import com.messaging_project.userservice.services.dtos.response.UserAddResponse;
import com.messaging_project.userservice.services.dtos.response.UserGetByIdResponse;
import com.messaging_project.userservice.services.dtos.response.UserUpdateResponse;
import com.messaging_project.userservice.services.rules.UserBusinessRules;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
@Service
@AllArgsConstructor
@RequiredArgsConstructor

public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;
    private final ModelMapperService modelMapperService;
    private final UserBusinessRules userBusinessRules;

    @Override
    public UserAddResponse addUser(UserAddRequest userAddRequest) {
        userBusinessRules.checkIfEmailIsAlreadyExist(userAddRequest.getEmail());
        userBusinessRules.checkIfuserNameIsAlreadyExist(userAddRequest.getUserName());

        User user = modelMapperService.forRequest().map(userAddRequest, User.class);
        user.setCreatedDate(LocalDateTime.now());
        user.setIsaActive(true);

        // User kaydı
        User savedUser = userRepository.save(user);

        // User -> UserAddResponse dönüşümü
        return modelMapperService.forResponse().map(savedUser, UserAddResponse.class);

    }

    @Override
    public UserUpdateResponse updateUser(int id, UserUpdateRequest userUpdateRequest) {
        // Kullanıcı var mı kontrolü
        userBusinessRules.checkIfUserExist(id);

        // Kullanıcıyı veritabanından getir
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // UserUpdateRequest -> User güncelleme
        modelMapperService.forRequest().map(userUpdateRequest, user);
        user.setUpdatedDate(LocalDateTime.now());

        // Güncellenmiş kullanıcıyı kaydet
        User updatedUser = userRepository.save(user);

        // User -> UserUpdateResponse dönüşümü
        return modelMapperService.forResponse().map(updatedUser, UserUpdateResponse.class);
    }

    @Override
    public UserGetByIdResponse getUserById(int userId) {
        // Kullanıcı var mı kontrolü
        userBusinessRules.checkIfUserExist(userId);

        // Kullanıcıyı veritabanından getir
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // User -> UserGetByIdResponse dönüşümü
        return modelMapperService.forResponse().map(user, UserGetByIdResponse.class);
    }

    @Override
    public List<UserGetByIdResponse> getAllUsers() {
        // Tüm kullanıcıları veritabanından al
        List<User> users = userRepository.findAll();

        // Her bir kullanıcıyı UserGetByIdResponse'e dönüştür
        return users.stream()
                .map(user -> modelMapperService.forResponse().map(user, UserGetByIdResponse.class))
                .collect(Collectors.toList());
    }
}