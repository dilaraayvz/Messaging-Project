package com.messaging_project.messageservice.clients;

import com.messaging_project.messageservice.clients.dtos.UserGetResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "authserver")
public interface AuthServiceClient {

    @GetMapping("/api/v1/auth/{id}")
    UserGetResponse getUserById(@PathVariable int id);
}
