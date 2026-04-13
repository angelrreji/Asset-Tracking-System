package com.asset.asset_tracking.service;

import org.springframework.stereotype.Service;

@Service
public class AuthService {
    public String login(String username,String password){
        if ("admin".equals(username) && "admin123".equals(password)) {
            return "Login successful";
        }
        return "Invalid credentials";
    }

    public String logout() {
        return "Logout successful";
    }
}
