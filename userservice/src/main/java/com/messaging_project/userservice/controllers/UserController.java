package com.messaging_project.userservice.controllers;

import com.messaging_project.userservice.services.abstracts.UserService;
import com.messaging_project.userservice.services.dtos.response.UserGetByIdResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private UserService userService;
    @GetMapping("/{id}")
    public ResponseEntity<UserGetByIdResponse> getUserById(@PathVariable int id){
            return null;
    }

}
