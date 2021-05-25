package com.example.spring_jwt_token_test.security;

import com.example.spring_jwt_token_test.model.UserRole;
import com.example.spring_jwt_token_test.service.Inter.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

         com.example.spring_jwt_token_test.model.User user =  userService.getUserByLogin(username);

//    return new User("Elvin","1",new ArrayList<>());

        return new User(user.getUsername() , user.getPassword(),
                new ArrayList<>());
    }
}