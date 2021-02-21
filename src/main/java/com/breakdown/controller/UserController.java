package com.breakdown.controller;

import com.breakdown.entity.Role;
import com.breakdown.entity.User;
import com.breakdown.model.RegisterUser;
import com.breakdown.model.UserDto;
import com.breakdown.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value="/all", method = RequestMethod.GET)
    public List<UserDto> listUser(){

        List<UserDto> userDtos = new ArrayList<>();
        for (User user:userService.findAll()) {
            UserDto userDto=new UserDto();
            userDto.setEmail(user.getEmail());
            userDto.setUsername(user.getUsername());
            userDto.setFirstName(user.getFirstName());
            userDto.setLastName(user.getLastName());
            userDto.setMobileNo(user.getMobileNo());
            user.getRoles().forEach(role -> userDto.getRoles().add(role.getRole()));
            userDtos.add(userDto);
        }
        return userDtos;
    }

    @RequestMapping(value = "/createUser", method = RequestMethod.POST)
    public ResponseEntity<?> createUser(@RequestBody RegisterUser registerUser) {
        User user=userService.create(registerUser);
        UserDto userDto=new UserDto();
        userDto.setUsername(user.getUsername());
        userDto.setEmail(user.getEmail());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setMobileNo(user.getMobileNo());
        user.getRoles().forEach(role -> userDto.getRoles().add(role.getRole()));
        return ResponseEntity.ok(userDto);
    }

    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    public ResponseEntity<?> updateUser(@RequestBody RegisterUser registerUser) {
        User user=userService.update(registerUser);
        UserDto userDto=new UserDto();
        userDto.setUsername(user.getUsername());
        userDto.setEmail(user.getEmail());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setMobileNo(user.getMobileNo());
        user.getRoles().forEach(role -> userDto.getRoles().add(role.getRole()));
        return ResponseEntity.ok(userDto);
    }



}
