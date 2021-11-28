package com.ApricotMarket.service;

import com.ApricotMarket.domain.User;

import java.util.Optional;

public interface checkService {
    int UserLogin(Long UserId);
    int UserLogout(Long UserId);
    Optional<User> findUser(String username);
    Optional<User> findloguser();
    String currentUserName();
}
