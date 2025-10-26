package com.achraf.security.service;

import com.achraf.security.dto.AuthRequest;
import com.achraf.security.dto.AuthResponse;
import com.achraf.security.model.User;

public interface AuthService {
    AuthResponse authenticate(AuthRequest request);
    User register(User user);
}
