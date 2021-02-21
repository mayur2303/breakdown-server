package com.breakdown.controller;

import com.breakdown.config.TokenProvider;
import com.breakdown.model.LoginUser;
import com.breakdown.model.UserDto;
import com.breakdown.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenProvider jwtTokenUtil;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    public ResponseEntity<?> register(@RequestBody LoginUser loginUser) throws AuthenticationException {

        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginUser.getUsername(),
                        loginUser.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        User user=(User) authentication.getPrincipal();
        List<String> roles=user.getAuthorities().stream().map(auth->auth.getAuthority()).collect(Collectors.toList());
        final String token = jwtTokenUtil.generateToken(authentication);
        com.breakdown.entity.User userServiceOne=userService.findOne(user.getUsername());
        UserDto userDto=new UserDto();
        userDto.setUsername(userServiceOne.getUsername());
        userDto.setEmail(userServiceOne.getEmail());
        userDto.setFirstName(userServiceOne.getFirstName());
        userDto.setLastName(userServiceOne.getLastName());
        userDto.setMobileNo(userServiceOne.getMobileNo());
        userDto.setToken(token);
        userServiceOne.getRoles().forEach(role -> userDto.getRoles().add(role.getRole()));

        return ResponseEntity.ok(userDto);
    }
}
