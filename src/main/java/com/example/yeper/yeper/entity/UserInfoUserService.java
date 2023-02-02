package com.example.yeper.yeper.entity;

import com.example.yeper.yeper.config.UserInfoUserDetails;
import com.example.yeper.yeper.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserInfoUserService implements UserDetailsService {

    @Autowired
    private UserDao userDao;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Users> user=userDao.findById(username);
        return user.map(UserInfoUserDetails::new).orElseThrow(()->new UsernameNotFoundException("User Not Found"));
//        return null;
    }
}
