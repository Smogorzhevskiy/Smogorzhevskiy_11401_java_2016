package com.smogorzhevskiy.repository;

import com.smogorzhevskiy.entities.Artist;
import com.smogorzhevskiy.entities.Credential;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by User on 19.04.16.
 */
@Repository
public interface ArtistRepository extends JpaRepository<Artist, java.lang.Integer> {
    Artist getOneByName(String name);
    Artist findOneByCredentialLogin(String login);
    List<Artist> findAll();
    Artist findOneByCredential(Credential credential);

}
