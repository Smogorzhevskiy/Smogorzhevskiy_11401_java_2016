package com.smogorzhevskiy.repository;

import com.smogorzhevskiy.entities.Artist;
import com.smogorzhevskiy.entities.Credential;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by User on 19.04.16.
 */
@Repository
public interface CredentialRepository extends JpaRepository<Credential,Integer> {
    Credential findOneByLogin(String login);
    Credential findOneByEmail(String email);

}
