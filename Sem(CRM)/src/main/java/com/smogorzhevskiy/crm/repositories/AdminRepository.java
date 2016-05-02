package com.smogorzhevskiy.crm.repositories;

import com.smogorzhevskiy.crm.entities.Credential;
import com.smogorzhevskiy.crm.entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by User on 19.04.16.
 */
@Repository
public interface AdminRepository extends JpaRepository<Admin,Integer>{
    Admin findOneByRoleEntity(Credential role);
    Admin findOneByCredentialLogin(String login);
}
