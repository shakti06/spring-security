package com.shakti.springsecurity.service;

import com.shakti.springsecurity.model.CustomDetail;
import com.shakti.springsecurity.model.User;
import com.shakti.springsecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionalUsers =   userRepository.findByUsername(username);

        optionalUsers.orElseThrow(() -> new UsernameNotFoundException("user name not found exception"));

        return optionalUsers.map(CustomDetail:: new).get();
    }
}
