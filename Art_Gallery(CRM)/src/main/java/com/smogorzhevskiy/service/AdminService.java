package com.smogorzhevskiy.service;

import com.smogorzhevskiy.entities.Admin;
import com.smogorzhevskiy.entities.Credential;
import com.smogorzhevskiy.entities.enums.Role;
import com.smogorzhevskiy.forms.AdminRegistrationForm;

import java.util.List;

/**
 * Created by User on 19.04.16.
 */
public interface AdminService {

    Admin findOneByCredentialLogin(String login);

    Admin findOneByCredential(Credential credential);

    void createAdmin(AdminRegistrationForm form);

    List <Admin> findAllByCredential_Role(Role role);
}
