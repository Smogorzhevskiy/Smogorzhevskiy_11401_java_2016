package com.smogorzhevskiy.service.impl;

import com.smogorzhevskiy.entities.Artist;
import com.smogorzhevskiy.entities.Credential;
import com.smogorzhevskiy.forms.ArtistCreationForm;
import com.smogorzhevskiy.repository.ArtistRepository;
import com.smogorzhevskiy.repository.CredentialRepository;
import com.smogorzhevskiy.service.ArtistService;
import com.smogorzhevskiy.utility.transformers.ArtistFromRegForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by User on 21.04.16.
 */
@Service
public class ArtistServiceImpl implements ArtistService {
    @Autowired
    private ArtistRepository artistRepository;

    @Autowired
    private CredentialRepository credentialRepository;

    @Transactional
    public void addArtist(ArtistCreationForm form){
        Credential credential = ArtistFromRegForm.transfromCredential(form);
        credentialRepository.save(credential);
        Artist moderator = ArtistFromRegForm.moderTransform(form, credential);
        artistRepository.save(moderator);
    }

    @Override
    public void delete(java.lang.Integer id) {
        artistRepository.delete(id);

    }

    @Override
    public Artist getByNameArtist(String name) {
        return null;
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
