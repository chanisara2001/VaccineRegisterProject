package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;



public class UserDetailService implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String pid) throws UsernameNotFoundException {
		User user = userRepository.findById(pid).orElse(null);
		if (user == null) {
            throw new UsernameNotFoundException("Could not find student user");
        }
		return new UserDetail(user);
	}
	
}
