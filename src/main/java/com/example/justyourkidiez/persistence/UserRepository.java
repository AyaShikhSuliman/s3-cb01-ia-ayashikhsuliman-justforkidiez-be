package com.example.justyourkidiez.persistence;

import com.example.justyourkidiez.persistence.entity.User.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByUsername(String username);
}
