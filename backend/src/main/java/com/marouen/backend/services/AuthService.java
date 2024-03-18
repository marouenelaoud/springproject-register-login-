package com.marouen.backend.services;

import com.marouen.backend.dto.SignupRequest;

public interface AuthService {
    boolean createUser(SignupRequest signupRequest);
}
