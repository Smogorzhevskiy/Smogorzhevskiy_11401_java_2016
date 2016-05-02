package com.smogorzhevskiy.crm.utility;

import com.smogorzhevskiy.crm.entities.Credential;
import com.smogorzhevskiy.crm.entities.enums.Role;
import com.smogorzhevskiy.crm.repositories.CredentialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;


/**
 * Created by User on 27.04.16.
 */
@Component
public class RoleFormCreator {

        static BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        @Autowired
        CredentialRepository credentialsRepository;

        public Credential createRoleForUser(String password, String login, String email, Role status) {
            Credential role = new Credential();
            role.setPassword(encoder.encode(password));
            role.setRole(status);
            role.setLogin(login);
            role.setEmail(email);
            credentialsRepository.save(role);
            return role;
        }

    }
