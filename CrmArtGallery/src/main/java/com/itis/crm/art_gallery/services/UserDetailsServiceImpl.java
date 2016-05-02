package com.itis.crm.art_gallery.services;

import com.itis.crm.art_gallery.entity.User;
import com.itis.crm.art_gallery.entity.enums.EnumUserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by User on 08.04.16.
 */
@Service
public class UserDetailsServiceImpl  implements UserDetailsService{
    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userService.getUser("gleb");
        Set<GrantedAuthority> roles = new HashSet();
        roles.add(new SimpleGrantedAuthority(EnumUserRole.UserRoleEnum.USER.name()));
        UserDetails details = new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(), roles);
        return details;
    }
}
