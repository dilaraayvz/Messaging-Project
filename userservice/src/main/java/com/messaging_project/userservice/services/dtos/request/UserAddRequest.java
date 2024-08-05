package com.messaging_project.userservice.services.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserAddRequest {
    private String userName;
    private String eMail;
    private String password;
    private String name;
    private String surname;

}