package com.example.spring_jwt_token_test.service.Impl;

import com.example.spring_jwt_token_test.model.User;
import com.example.spring_jwt_token_test.model.UserRole;
import com.example.spring_jwt_token_test.repository.Inter.UserRepository;
import com.example.spring_jwt_token_test.service.Inter.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    public UserRepository userRepository;

    @Override
    public User loginUser(String username, String password) {
        try {
            return userRepository.loginUser(username, password);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public User getUserByLogin(String username) {
        try {
            return userRepository.getUserByLogin(username);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean addUser(User user) {
        try {
            return userRepository.addUser(user);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteUser(Long userId) {
        try {
            return userRepository.deleteUser(userId);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean updateUser(User user) {
        try {
            return userRepository.updateUser(user);
        } catch (Exception e) {
            e.printStackTrace();
            return false;

        }
    }

    @Override
    public List<User> getUserList() {
        try {
            return userRepository.getUserList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;

        }
    }

    @Override
    public List<UserRole> userRoleList() {
        try {
            return userRepository.userRoleList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public User getUserById(Long userId) {
        try {
            return userRepository.getUserById(userId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<User> getUserSearch(String keyword) {
        try {
            return userRepository.getUserSearch(keyword);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
