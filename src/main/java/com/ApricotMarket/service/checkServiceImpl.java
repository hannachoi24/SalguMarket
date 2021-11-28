package com.ApricotMarket.service;

import com.ApricotMarket.repository.checkRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class checkServiceImpl implements checkService {

    public checkServiceImpl(checkRepository checkRepository) {
        this.checkRepository = checkRepository;
    }

    private final checkRepository checkRepository;

    @Override
    @Transactional
    public int UserLogin(Long UserId) {
        return this.checkRepository.UserLogin(UserId);
    }

    @Override
    @Transactional
    public int UserLogout(Long UserId) {
        return this.checkRepository.UserLogout(UserId);
    }

    @Override
    public Optional<com.ApricotMarket.domain.User> findUser(String username) {
        return this.checkRepository.finduser(username);
    }

    @Override
    public Optional<com.ApricotMarket.domain.User> findloguser() {
        return this.checkRepository.findloguser();
    }

    @Override
    public String currentUserName() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        User user = (User) authentication.getPrincipal();

        return user.getUsername();
    }

//    @Override
//    public static String currentUserName(){
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//
//        User user = (User) authentication.getPrincipal();
//
//        return user.getUsername();
//    }
}
