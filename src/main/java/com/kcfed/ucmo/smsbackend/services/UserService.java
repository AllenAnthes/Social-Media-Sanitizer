package com.kcfed.ucmo.smsbackend.services;

import com.kcfed.ucmo.smsbackend.models.User;

public interface UserService {

    void save(User user);

    User findByUsername(String username);
}
