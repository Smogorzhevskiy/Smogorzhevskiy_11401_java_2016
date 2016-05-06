package com.smogorzhevskiy.service.impl;

import com.smogorzhevskiy.entities.Admin;
import com.smogorzhevskiy.entities.Credential;
import com.smogorzhevskiy.entities.enums.Role;
import com.smogorzhevskiy.forms.AdminRegistrationForm;
import com.smogorzhevskiy.repository.AdminRepository;
import com.smogorzhevskiy.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by User on 21.04.16.
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminRepository adminRepository;

    @Override
    public Admin findOneByCredentialLogin(String login) {
        return adminRepository.findOneByCredentialLogin(login);
    }

    @Override
    public Admin findOneByCredential(Credential credential) {
        return adminRepository.findOneByCredential(credential);
    }

    @Override
    public void createAdmin(AdminRegistrationForm form) {

    }

    @Override
    public List<Admin> findAllByCredential_Role(Role role) {
        return adminRepository.findAllByCredential_Role(role);
    }
}
