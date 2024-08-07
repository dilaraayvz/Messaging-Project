package com.messaging_project.userservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@MappedSuperclass
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "createDate")
    private LocalDateTime createdDate;

    @Column(name = "updateDate")
    private LocalDateTime updatedDate;

    @Column(name = "deleteDate")
    private LocalDateTime deletedDate;

    @Column(name = "isaActive")
    private Boolean isaActive;
    @PrePersist
    protected void onCreate() {
        createdDate = LocalDateTime.now();
        isaActive = true;
    }

    @PreUpdate
    protected void onUpdate() {
        updatedDate = LocalDateTime.now();
    }

    @PreRemove
    protected void onRemove() {
        deletedDate = LocalDateTime.now();
        isaActive = false;
    }

}
