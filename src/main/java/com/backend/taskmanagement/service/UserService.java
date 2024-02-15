package com.backend.taskmanagement.service;

import com.backend.taskmanagement.model.User;

public interface UserService {
    public User findUserById(Long userId) throws Exception;
}
