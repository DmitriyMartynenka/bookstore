package org.example.bookstore.service;

import lombok.RequiredArgsConstructor;
import org.example.bookstore.dao.UserEntity;
import org.example.bookstore.dao.UserRepository;
import org.example.bookstore.model.request.UserCreateRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DefaultUserService implements UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public void register(UserCreateRequest createRequest) {
        Optional<UserEntity> byUsername = userRepository.findByUsername(createRequest.getUsername());
        if (byUsername.isPresent()) {
            throw new RuntimeException("User already registered");
        }
        UserEntity user = new UserEntity();
        user.setUsername(createRequest.getUsername());
        user.setPassword(passwordEncoder.encode(createRequest.getPassword()));
        userRepository.save(user);
    }

    @Override
    public UserEntity findByUsername(String name) {
        return userRepository.findByUsername(name).orElseThrow(EntityNotFoundException::new);
    }
}