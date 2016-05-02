package com.smogorzhevskiy.crm.service.impl;

import com.smogorzhevskiy.crm.entities.Artist;
import com.smogorzhevskiy.crm.entities.Credential;
import com.smogorzhevskiy.crm.forms.ArtistCreationForm;
import com.smogorzhevskiy.crm.repositories.ArtistRepository;
import com.smogorzhevskiy.crm.repositories.CredentialRepository;
import com.smogorzhevskiy.crm.service.ArtistService;
import com.sun.tools.javac.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.function.Function;

/**
 * Created by User on 21.04.16.
 */
@Service
public class ArtistServiceImpl implements ArtistService {
    @Autowired
    private ArtistRepository artistRepository;
    @Autowired
    private CredentialRepository roleRepository;

    @Autowired
    Function<ArtistCreationForm, Artist> function;

    @Transactional
    @Override
    public void addArtist(ArtistCreationForm form) {
        Artist artist = function.apply(form);
        artistRepository.save(artist);



    }

    @Override
    public void delete(Integer id) {
        artistRepository.delete(id);

    }

    @Override
    public Artist getByNameArtist(String name) {
        return artistRepository.findByName(name);
    }

    @Override
    public Artist editArtist(Artist bank) {
        return null;
    }

    @Override
    public List<Artist> getAllArtists() {
        return (List<Artist>) artistRepository.findAll();
    }

    @Override
    public Artist findByOneRole(Credential role) {
        return null;
    }
}
