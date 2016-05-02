package com.smogorzhevskiy.crm.service.impl;

import com.smogorzhevskiy.crm.entities.Admin;
import com.smogorzhevskiy.crm.entities.Credential;
import com.smogorzhevskiy.crm.repositories.AdminRepository;
import com.smogorzhevskiy.crm.service.AdminService;
import org.springframework.stereotype.Service;

/**
 * Created by User on 21.04.16.
 */
@Service
public class AdminServiceImpl implements AdminService {
    AdminRepository adminRepository;
    @Override
    public AdminService findOneByRole(Credential currentUser) {
        return null;
    }

    @Override
    public Admin findOneByCredentialLogin(String login) {
        return adminRepository.findOneByCredentialLogin(login);
    }
}
