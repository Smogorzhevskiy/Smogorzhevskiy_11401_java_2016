package com.smogorzhevskiy.service;

import com.smogorzhevskiy.entities.Artist;
import com.smogorzhevskiy.entities.Credential;
import com.smogorzhevskiy.forms.ArtistCreationForm;

import java.util.List;


/**
 * Created by User on 19.04.16.
 */
public interface ArtistService {
    void createArtist(ArtistCreationForm form);
    void delete(Integer id);
    Artist getOneByName(String name);
    Artist findOneByCredentialLogin(String login);
    List<Artist> findAll();
    Artist findOneByCredential(Credential role);

}
