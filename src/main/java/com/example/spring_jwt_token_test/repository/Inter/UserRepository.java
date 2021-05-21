package com.example.spring_jwt_token_test.repository.Inter;

import com.example.spring_jwt_token_test.model.User;
import com.example.spring_jwt_token_test.model.UserRole;


import java.util.List;

public interface UserRepository {

    List<User> getUserList() throws  Exception;

    User getUserById(Long userId) throws Exception;

    User loginUser (String username, String password)throws  Exception;

    User getUserByLogin(String username) throws  Exception;

    boolean addUser (User user) throws  Exception;

    boolean updateUser (User user) throws  Exception;

    boolean deleteUser(Long userId) throws  Exception;

    List<UserRole>userRoleList()throws Exception;

    List<User>getUserSearch(String keyword) throws  Exception;
}
