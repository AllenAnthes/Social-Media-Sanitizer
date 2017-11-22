package com.kcfed.ucmo.smsbackend.services;

public interface SecurityService {
    String findLoggedInUsername();

    void autologin(String username, String password);
}
