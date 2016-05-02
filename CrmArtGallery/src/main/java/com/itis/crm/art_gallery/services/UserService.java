package com.itis.crm.art_gallery.services;

import com.itis.crm.art_gallery.entity.User;

/**
 * Created by User on 07.04.16.
 */
public interface UserService {

    User getUser(String login);
}
