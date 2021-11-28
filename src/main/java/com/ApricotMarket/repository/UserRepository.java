package com.ApricotMarket.repository;

import com.ApricotMarket.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    // boolean existsUserByEmail(String email);
    // User findByUsername(String username);
//    int UserLogin(Long UserId);
//    int UserLogout(Long UserId);
}