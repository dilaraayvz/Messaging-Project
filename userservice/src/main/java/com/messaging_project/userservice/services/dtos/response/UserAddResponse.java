package com.messaging_project.userservice.services.dtos.response;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserAddResponse {
    private int id;
    private String userName;
    private String email;
    private String password;
    private String name;
    private String surname;
}
