package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
    private UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public User saveUser(User user) {
    	User userEncode = encodePassword(user);
        return userRepository.save(userEncode);
    }

    private User encodePassword(User user) {
    	user.setPassword(passwordEncoder.encode(user.getPassword()));
        return user;
    }
}
