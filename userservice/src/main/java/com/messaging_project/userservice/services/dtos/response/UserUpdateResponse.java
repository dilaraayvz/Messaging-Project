package com.messaging_project.userservice.services.dtos.response;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
public class UserUpdateResponse {
    private int id;
    private String name;
    private String surname;
    private String eMail;
    private String userName;
}
