package com.example.spring_jwt_token_test.service.Inter;

import com.example.spring_jwt_token_test.model.User;
import com.example.spring_jwt_token_test.model.UserRole;

import java.util.List;

public interface UserService {

    public User loginUser (String username, String password);

    User getUserByLogin(String username);

    boolean addUser (User user) ;

    boolean deleteUser(Long userId);

    boolean updateUser (User user);

    List<User> getUserList() ;

    List<UserRole>userRoleList();

    User getUserById(Long userId);

    List<User>getUserSearch(String keyword);

}

