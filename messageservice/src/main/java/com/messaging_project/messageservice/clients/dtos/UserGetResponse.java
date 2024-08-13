package com.messaging_project.messageservice.clients.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserGetResponse {
    private int id;
    private String name;
    private String surname;
    private String email;
    private String userName;

}
