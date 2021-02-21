package com.breakdown.service.impl;

import com.breakdown.dao.RoleDao;
import com.breakdown.dao.UserDao;
import com.breakdown.entity.Role;
import com.breakdown.entity.User;
import com.breakdown.model.RegisterUser;
import com.breakdown.model.RoleModel;
import com.breakdown.model.UserDto;
import com.breakdown.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;


@Service(value = "userService")
public class UserServiceImpl implements UserDetailsService, UserService {
	
	@Autowired
	private UserDao userDao;

	@Autowired
	private RoleDao roleDao;

	@Autowired
	private BCryptPasswordEncoder bcryptEncoder;

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userDao.findByUsername(username);
		if(user == null){
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthority(user));
	}


	@Override
	public Set<SimpleGrantedAuthority> getAuthority(User user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
		user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getRole()));
		});
		return authorities;
	}

	@Override
	public List<User> findAll() {
		List<User> list = new ArrayList<>();
		userDao.findAll().iterator().forEachRemaining(list::add);
		return list;
	}

	@Override
	public User create(RegisterUser registerUser){
		User user = new User();
		user.setUsername(registerUser.getUsername());
		user.setPassword(bcryptEncoder.encode(registerUser.getPassword()));
		user.setEmail(registerUser.getEmail());
		user.setFirstName(registerUser.getFirstName());
		user.setLastName(registerUser.getLastName());
		user.setMobileNo(registerUser.getMobileNo());
		for (Long roleId: registerUser.getRoleIds()) {
			roleDao.findById(roleId).ifPresent(role1 -> user.getRoles().add(role1));
		}
		return userDao.save(user);

	}

	@Override
	public User update(RegisterUser registerUser) {
		if(registerUser!=null && registerUser.getUsername()!=null){
			User user=userDao.findByUsername(registerUser.getUsername());
			user.setUsername(registerUser.getUsername());
			user.setEmail(registerUser.getEmail());
			user.setFirstName(registerUser.getFirstName());
			user.setLastName(registerUser.getLastName());
			user.setMobileNo(registerUser.getMobileNo());
			user.getRoles().clear();
			for (Long roleId : registerUser.getRoleIds()) {
				roleDao.findById(roleId).ifPresent(role1 -> user.getRoles().add(role1));
			}

			return userDao.save(user);
		}
		return null;
	}

	@Override
	public void delete(long id) {
		userDao.deleteById(id);
	}

	@Override
	public User findOne(String username) {
		return userDao.findByUsername(username);
	}

	@Override
	public User findById(Long id) {
		return userDao.findById(id).get();
	}
}
