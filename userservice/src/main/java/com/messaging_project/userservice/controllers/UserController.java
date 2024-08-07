package com.messaging_project.userservice.controllers;

import com.messaging_project.userservice.services.abstracts.UserService;
import com.messaging_project.userservice.services.dtos.request.UserAddRequest;
import com.messaging_project.userservice.services.dtos.request.UserUpdateRequest;
import com.messaging_project.userservice.services.dtos.response.UserAddResponse;
import com.messaging_project.userservice.services.dtos.response.UserGetByIdResponse;
import com.messaging_project.userservice.services.dtos.response.UserUpdateResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // Kullanıcıyı ID ile getirme
    @GetMapping("/{id}")
    public ResponseEntity<UserGetByIdResponse> getUserById(@PathVariable int id) {
        UserGetByIdResponse user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    // Tüm kullanıcıları listeleme
    @GetMapping
    public ResponseEntity<List<UserGetByIdResponse>> getAllUsers() {
        List<UserGetByIdResponse> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    // Yeni kullanıcı ekleme
    @PostMapping
    public ResponseEntity<UserAddResponse> addUser(@RequestBody UserAddRequest userAddRequest) {
        UserAddResponse response = userService.addUser(userAddRequest);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // Kullanıcı güncelleme
    @PutMapping("/{id}")
    public ResponseEntity<UserUpdateResponse> updateUser(@PathVariable int id, @RequestBody UserUpdateRequest userUpdateRequest) {
        UserUpdateResponse response = userService.updateUser(id, userUpdateRequest);
        return ResponseEntity.ok(response);
    }

    // Kullanıcı silme
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
