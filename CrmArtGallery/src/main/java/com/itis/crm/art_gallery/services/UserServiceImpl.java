package com.itis.crm.art_gallery.services;

import com.itis.crm.art_gallery.entity.User;
import org.springframework.stereotype.Service;

/**
 * Created by User on 07.04.16.
 */
@Service
public class UserServiceImpl implements UserService{

    public User getUser(String login) {
        User user = new User();
        user.setLogin(login);
        user.setPassword("1234");
        return user;
    }
}
