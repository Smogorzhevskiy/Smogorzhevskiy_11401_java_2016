package com.smogorzhevskiy.service.impl;

import com.smogorzhevskiy.entities.Admin;
import com.smogorzhevskiy.entities.Credential;
import com.smogorzhevskiy.repository.AdminRepository;
import com.smogorzhevskiy.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by User on 21.04.16.
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminRepository adminRepository;

    @Override
    public Admin findOneByCredential(Credential credential) {
        return adminRepository.findOneByCredential(credential);
    }
}
