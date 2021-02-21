package com.breakdown.service;

import com.breakdown.entity.User;
import com.breakdown.model.RegisterUser;
import com.breakdown.model.UserDto;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.Set;

public interface UserService {

    Set<SimpleGrantedAuthority> getAuthority(User user);
    List<User> findAll();

    User create(RegisterUser registerUser);

    User update(RegisterUser registerUser);

    void delete(long id);
    User findOne(String username);
    User findById(Long id);
}
