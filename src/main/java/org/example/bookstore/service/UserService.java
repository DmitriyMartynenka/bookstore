package org.example.bookstore.service;

import org.example.bookstore.dao.UserEntity;
import org.example.bookstore.model.request.UserCreateRequest;

public interface UserService {
    void register(UserCreateRequest createRequest);

    UserEntity findByUsername(String name);
}