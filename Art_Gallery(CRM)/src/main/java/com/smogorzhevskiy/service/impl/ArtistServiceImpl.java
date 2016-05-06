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
    public void createArtist(ArtistCreationForm form){
        Credential credential = ArtistFromRegForm.transformCredential(form);
        credentialRepository.save(credential);
        Artist artist = ArtistFromRegForm.artistTransform(form, credential);
        artistRepository.save(artist);
    }

    @Override
    public void delete(java.lang.Integer id) {
        artistRepository.delete(id);

    }

    @Override
    public Artist getOneByName(String name) {
        return artistRepository.getOneByName(name);
    }

    @Override
    public Artist findOneByCredentialLogin(String login) {
        return artistRepository.findOneByCredentialLogin(login);
    }

    @Override
    public List<Artist> findAll() {
        return (List<Artist>) artistRepository.findAll();
    }

    @Override
    public Artist findOneByCredential(Credential credential) {
        return artistRepository.findOneByCredential(credential);
    }
}
