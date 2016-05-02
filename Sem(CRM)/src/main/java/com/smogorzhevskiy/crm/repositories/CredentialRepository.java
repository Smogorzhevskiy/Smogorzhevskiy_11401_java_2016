package com.smogorzhevskiy.crm.repositories;

import com.smogorzhevskiy.crm.entities.Credential;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by User on 19.04.16.
 */
@Repository
public interface CredentialRepository extends JpaRepository<Credential,Integer> {
    Credential findOneByLogin(String login);
}
