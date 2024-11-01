package com.microservicestock.application.Security.service;

import com.microservicestock.domain.user.entity.UserEntity;
import com.microservicestock.domain.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

        @Autowired
        private UserRepository userRepository;

        public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

            UserEntity user = userRepository.findUserEntityByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User not found"));

            List<SimpleGrantedAuthority> authorities = new ArrayList<>();

            authorities.add(new SimpleGrantedAuthority(user.getRole().name()));

            return new User(user.getEmail(), user.getPassword(), authorities);
        }
}
