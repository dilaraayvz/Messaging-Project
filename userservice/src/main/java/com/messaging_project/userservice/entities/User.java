package com.messaging_project.userservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users")
public class User extends BaseEntity {
    @SequenceGenerator(
            name = "base_sequence_generator",
            sequenceName = "customer_sequence",
            allocationSize = 1
    )
    @Column(name = "userName", nullable = false, unique = true)
    private String userName;
    @Column(name = "eMail", nullable = false, unique = true)
    private String email;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name="lastSeen")
    private Date lastSeen;

}
