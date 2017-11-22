package com.kcfed.ucmo.smsbackend.repository;

import com.kcfed.ucmo.smsbackend.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
