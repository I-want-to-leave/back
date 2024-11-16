package com.example.i_want_to_leave.login.basic.service;

import com.example.i_want_to_leave.entity.User;
import com.example.i_want_to_leave.login.basic.dto.BasicAuthenticationDTO;
import com.example.i_want_to_leave.login.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class BasicAuthenticationUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    public BasicAuthenticationUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if(user == null){
            return null;
        }
        BasicAuthenticationDTO basicAuthenticationDTO = BasicAuthenticationDTO.from(user);
        return new BasicAuthenticationUserDetails(basicAuthenticationDTO);
    }
}
