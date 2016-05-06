package com.smogorzhevskiy.repository;

import com.smogorzhevskiy.entities.Credential;
import com.smogorzhevskiy.entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by User on 19.04.16.
 */
@Repository
public interface AdminRepository extends JpaRepository<Admin,Integer>{
//    Admin findOneByRoleEntity(Credential role);
    Admin findOneByCredential(Credential credential);
}
