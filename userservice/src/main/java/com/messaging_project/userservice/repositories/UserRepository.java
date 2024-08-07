package com.messaging_project.userservice.repositories;

import com.messaging_project.userservice.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Date;
import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String eMail);
    Optional<User> findById(int id);
    Date findLastSeenById(int id);
    boolean existsByEmail(String eMail);
    boolean existsByUserName(String userName);
    String findUserNameById(int id);
    Optional<User> findByUserName(String userName);
}
