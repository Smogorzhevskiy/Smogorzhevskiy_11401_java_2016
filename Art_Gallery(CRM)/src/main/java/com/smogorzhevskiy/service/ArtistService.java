package com.smogorzhevskiy.service;

import com.smogorzhevskiy.entities.Artist;
import com.smogorzhevskiy.entities.Credential;
import com.smogorzhevskiy.forms.ArtistCreationForm;

import java.util.List;


/**
 * Created by User on 19.04.16.
 */
public interface ArtistService {
    void addArtist(ArtistCreationForm form);
    void delete(java.lang.Integer id);
    Artist getByNameArtist(String name);
    Artist editArtist(Artist bank);
    List<Artist> getAllArtists();
    Artist findByOneRole(Credential role);
}
