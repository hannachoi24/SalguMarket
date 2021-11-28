package com.ApricotMarket.repository;

import com.ApricotMarket.domain.User;

import java.util.Optional;

public interface checkRepository {
    int UserLogin(Long UserId);
    int UserLogout(Long UserId);
    Optional<User> finduser(String username);
    Optional<User> findloguser();
}
