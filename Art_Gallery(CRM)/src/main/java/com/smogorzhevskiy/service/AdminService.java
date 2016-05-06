package com.smogorzhevskiy.service;

import com.smogorzhevskiy.entities.Admin;
import com.smogorzhevskiy.entities.Credential;

/**
 * Created by User on 19.04.16.
 */
public interface AdminService {
    Admin findOneByCredential(Credential credential);
}
