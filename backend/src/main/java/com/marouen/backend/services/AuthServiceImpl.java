package com.marouen.backend.services;

import com.marouen.backend.dto.SignupRequest;
import com.marouen.backend.entities.AppUser;
import com.marouen.backend.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService{

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AuthServiceImpl(UserRepository userRepository , PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;

    }

    @Override
    public boolean createUser(SignupRequest signupRequest) {
        //check id user already exists
        if(userRepository.existsByEmail(signupRequest.getEmail())){
            return false;
        }

        AppUser user = new AppUser();
        BeanUtils.copyProperties(signupRequest, user);
        String hashPassword = passwordEncoder.encode(signupRequest.getPassword());
        user.setPassword(hashPassword);
        userRepository.save(user);
        return true;
    }
}
