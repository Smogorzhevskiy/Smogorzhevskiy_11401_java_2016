package com.smogorzhevskiy.service.impl;

import com.smogorzhevskiy.entities.Artist;
import com.smogorzhevskiy.entities.Credential;
import com.smogorzhevskiy.forms.ArtistCreationForm;
import com.smogorzhevskiy.repository.ArtistRepository;
import com.smogorzhevskiy.repository.CredentialRepository;
import com.smogorzhevskiy.repository.DirectionRepository;
import com.smogorzhevskiy.repository.GalleryRepository;
import com.smogorzhevskiy.service.ArtistService;
import com.smogorzhevskiy.utility.transformers.TransformFromRegForm;
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
    @Autowired
    private GalleryRepository galleryRepository;
    @Autowired
    private DirectionRepository directionRepository;

    @Transactional
    public void createArtist(ArtistCreationForm form) {


        Credential credential = TransformFromRegForm.transformArtistFormCredential(form);
        credentialRepository.save(credential);
        Artist artist = new Artist();
        artist.setName(form.getName());
        artist.setCredential(credential);
        artist.setSurname(form.getSurname());
        artist.setDirection(directionRepository.findOneByName(form.getDirection()));
        artist.setDirection_id(directionRepository.findOneByName(form.getDirection()).getId());
        artist.setGallery(galleryRepository.findOneByName(form.getGallery()));
        artist.setGallery_id(galleryRepository.findOneByName(form.getGallery()).getId());
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
