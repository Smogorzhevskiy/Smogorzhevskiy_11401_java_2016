package com.smogorzhevskiy.crm.service;

import com.smogorzhevskiy.crm.entities.Artist;
import com.smogorzhevskiy.crm.entities.Credential;
import com.smogorzhevskiy.crm.forms.ArtistCreationForm;
import com.sun.tools.javac.util.List;



/**
 * Created by User on 19.04.16.
 */
public interface ArtistService {
    void addArtist(ArtistCreationForm form);
    void delete(Integer id);
    Artist getByNameArtist(String name);
    Artist editArtist(Artist bank);
    List<Artist> getAllArtists();
    Artist findByOneRole(Credential role);
}
