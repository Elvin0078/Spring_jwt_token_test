package com.example.spring_jwt_token_test;

import com.example.spring_jwt_token_test.model.User;
import com.example.spring_jwt_token_test.repository.Impl.UserRepositoryImpl;
import com.example.spring_jwt_token_test.repository.Inter.UserRepository;
import com.example.spring_jwt_token_test.security.JwtRequestFilter;
import com.example.spring_jwt_token_test.service.Impl.UserServiceImpl;
import com.example.spring_jwt_token_test.service.Inter.BookService;
import com.example.spring_jwt_token_test.service.Inter.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringJwtTokenTestApplicationTests {

@Autowired
public BookService bookService;

@Autowired
public UserService userService;

@Autowired
public UserRepository userRepository;




    @Test
    void contextLoads() {
        System.out.println(userService.getUserList().toString());



    }

}
