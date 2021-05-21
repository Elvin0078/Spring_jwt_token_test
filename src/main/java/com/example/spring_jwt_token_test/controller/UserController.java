package com.example.spring_jwt_token_test.controller;


import com.example.spring_jwt_token_test.model.AuthenticationRequest;
import com.example.spring_jwt_token_test.model.AuthenticationResponse;
import com.example.spring_jwt_token_test.model.User;
import com.example.spring_jwt_token_test.model.UserRole;
import com.example.spring_jwt_token_test.security.JwtUtil;
import com.example.spring_jwt_token_test.security.MyUserDetailsService;
import com.example.spring_jwt_token_test.service.Inter.UserService;
import com.example.spring_jwt_token_test.util.DataConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/user")
public class UserController {

    @Autowired
    public UserService userService;


    @GetMapping("/login")
    public ResponseEntity<?> getUser(@RequestParam("username") String username,
                                     @RequestParam("password") String password) {
        User user = userService.loginUser(username, password);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/userList")
    public ResponseEntity<?> getuserList() {
        List<User> userList = userService.getUserList();
        return new ResponseEntity<>(userList, HttpStatus.OK);

    }


    @PostMapping("/newUser")
    public ResponseEntity<?> addUser(@RequestParam("fullname") String fullname,
                                     @RequestParam("username") String username,
                                     @RequestParam("password") String password,
                                     @RequestParam("dob") String DOB,
                                     @RequestParam("phone") String phone,
                                     @RequestParam("userRoleId") Long userRoleId) {

        UserRole userRole = new UserRole();
        userRole.setRoleId(userRoleId);

        DataConverter dataConverter = new DataConverter();


        User user = new User(null, fullname, username, password, phone, dataConverter.stringToDate(DOB), null, userRole);

        boolean result = userService.addUser(user);

        return new ResponseEntity<>(result, HttpStatus.OK);

    }

    @PutMapping("/updateUser")
    public ResponseEntity<?> updateUser(@RequestParam("fullName") String fullname,
                                        @RequestParam("username") String username,
                                        @RequestParam("password") String password,
                                        @RequestParam("dob") String DOB,
                                        @RequestParam("phone") String phone,
                                        @RequestParam("userRoleId") Long userRoleId,
                                        @RequestParam("userId") Long userId) {

        UserRole userRole = new UserRole();
        userRole.setRoleId(userRoleId);

        DataConverter dataConverter = new DataConverter();

        User user = new User(userId, fullname, username, password, phone, dataConverter.stringToDate(DOB), null, userRole);
        boolean result = userService.updateUser(user);
        System.out.println(user.toString());
        return new ResponseEntity<>(result, HttpStatus.OK);

    }

    @GetMapping("/userByName")
    ResponseEntity<?> getUserByName(@RequestParam("username") String username) {

        User user = userService.getUserByLogin(username);
        return new ResponseEntity<>(user, HttpStatus.OK);


    }

    @GetMapping("/userRoleList")
    ResponseEntity<?> getUserRolelist() {
        List<UserRole> userRoleList = new ArrayList();
        userRoleList = userService.userRoleList();
        return new ResponseEntity<>(userRoleList, HttpStatus.OK);
    }

    @GetMapping("/userbyid")
    ResponseEntity<?> getUserById(@RequestParam("userId") Long userid) {
        User user = new User();
        user = userService.getUserById(userid);
        return new ResponseEntity(user, HttpStatus.OK);

    }

    @PutMapping("/deleteUser")
    ResponseEntity<?> deleteUser(@RequestParam("userId") Long userId) {
        boolean result = userService.deleteUser(userId);
        return new ResponseEntity<>(result, HttpStatus.OK);

    }

    @GetMapping("/searchUser")
    ResponseEntity<?> searchUsers(@RequestParam("keyword") String keyword) {
        List<User> userList = userService.getUserSearch(keyword);
        return new ResponseEntity<>(userList, HttpStatus.OK);

    }

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/authenticate")
    ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

        try {


            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));

        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password ", e);

        }
        final UserDetails userDetails = myUserDetailsService.loadUserByUsername(authenticationRequest.getUsername());

        final String jwt = jwtUtil.generateToken(userDetails);

        return new ResponseEntity<>(new AuthenticationResponse(jwt), HttpStatus.OK);


    }


}
