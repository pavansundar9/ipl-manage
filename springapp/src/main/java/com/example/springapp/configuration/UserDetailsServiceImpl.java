package com.example.springapp.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.springapp.entity.User;
import com.example.springapp.repository.UserRepo;




@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepo userRepo;

    @Autowired
    public UserDetailsServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("in load by userName");
        User user = userRepo.findByUsername(username);
        if (user == null) {
            System.out.println("user not found in from sysout");
            throw new UsernameNotFoundException("Invalid username");
        }
        return new UserPrinciple(user);
    }
}