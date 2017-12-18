package com.kinopoisk.security.controller;

import com.kinopoisk.security.JwtUser;
import com.kinopoisk.security.model.Authority;
import com.kinopoisk.security.model.User;
import com.kinopoisk.security.model.UserDetails;
import com.kinopoisk.security.repository.AutoritiesRepository;
import com.kinopoisk.security.repository.UserRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Maksim Shkurko on 12/18/2017
 *
 * @author m.shkurko
 */

@RestController
@RequestMapping("/api")
public class RegistrationRestController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    AutoritiesRepository autoritiesRepository;

    @Autowired
    private UserDetailsService userDetailsService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ApiOperation(value = "Create new User")
    public JwtUser createNewUser(@Valid @RequestBody UserDetails userDetails){
        User user = new User();
        Set<Authority> authorities = new HashSet<>();
        Authority authority = autoritiesRepository.getOne(1L);
        authorities.add(authority);
        user.setUsername(userDetails.getUsername());
        user.setEmail(userDetails.getEmail());
        user.setPassword(bCryptPasswordEncoder.encode(userDetails.getPassword()));
        user.setLastPasswordResetDate(new Date());
        user.setEnabled(true);
        user.setAuthorities(authorities);
        userRepository.save(user);
        JwtUser userToSave = (JwtUser) userDetailsService.loadUserByUsername(user.getUsername());

        return userToSave;
    }
}