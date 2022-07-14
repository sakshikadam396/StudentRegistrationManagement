package com.greatlearning.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.greatlearning.library.entity.User;
import com.greatlearning.library.repositories.UserRepository;
import com.greatlearning.library.security.StudentUserDetails;

public class UserServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepo;


	@Override
	public UserDetails loadUserByUsername(String username) {
		User user=userRepo.getUserByUserName(username);
		
		if(user==null)
		{
			throw new UsernameNotFoundException("User "+username+" not found!!!");
		}
		
		UserDetails studentUserDetails=new StudentUserDetails(user);
		return studentUserDetails;
	}

