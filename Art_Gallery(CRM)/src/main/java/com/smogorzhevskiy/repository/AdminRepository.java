package com.smogorzhevskiy.repository;

import com.smogorzhevskiy.entities.Credential;
import com.smogorzhevskiy.entities.Admin;
import com.smogorzhevskiy.entities.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by User on 19.04.16.
 */
@Repository
public interface AdminRepository extends JpaRepository<Admin,Integer>{
    Admin findOneByCredentialLogin(String login);

    Admin findOneByCredential(Credential credential);
    List<Admin> findAllByCredential_Role(Role role);
}
