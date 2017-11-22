package com.kcfed.ucmo.smsbackend.repository;

import com.kcfed.ucmo.smsbackend.models.Role;
import com.kcfed.ucmo.smsbackend.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface RoleRepository extends JpaRepository<Role, Long> {
}
