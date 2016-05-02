package com.smogorzhevskiy.crm.service;

import com.smogorzhevskiy.crm.entities.Admin;
import com.smogorzhevskiy.crm.entities.Credential;

/**
 * Created by User on 19.04.16.
 */
public interface AdminService {
    AdminService findOneByRole(Credential currentUser);
    Admin findOneByCredentialLogin(String login);
}
