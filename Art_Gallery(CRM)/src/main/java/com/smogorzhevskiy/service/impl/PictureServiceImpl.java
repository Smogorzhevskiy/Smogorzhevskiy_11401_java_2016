package com.smogorzhevskiy.service.impl;

import com.smogorzhevskiy.entities.Artist;
import com.smogorzhevskiy.entities.Gallery;
import com.smogorzhevskiy.entities.Picture;
import com.smogorzhevskiy.forms.PictureCreationForm;
import com.smogorzhevskiy.repository.ArtistRepository;
import com.smogorzhevskiy.repository.GalleryRepository;
import com.smogorzhevskiy.repository.PictureRepository;
import com.smogorzhevskiy.service.PictureService;
import com.smogorzhevskiy.utility.transformers.PictureFromCreateForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by User on 21.04.16.
 */
@Service
public class PictureServiceImpl implements PictureService {

    @Autowired
    private PictureRepository pictureRepository;
    @Autowired
    private ArtistRepository artistRepository;
    @Autowired
    private GalleryRepository galleryRepository;

    @Override
    public Picture createPicture(PictureCreationForm form) {
        if(form == null)
            return null;
        Picture picture = new Picture();
        picture.setName(form.getName());
        picture.setArtist_id(artistRepository.getOneByName(form.getArtist()).getId());
        picture.setGallery_id(galleryRepository.findOneByName(form.getGallery()).getId());
        pictureRepository.save(picture);
        return  picture;
    }

    @Override
    public void deletePicture(java.lang.Integer id) {
        pictureRepository.delete(pictureRepository.findOneById(id));
    }

    @Override
    public Picture findOneById(java.lang.Integer id) {
        return pictureRepository.findOneById(id);
    }

    @Override
    public List<Picture> findAllByArtist(Artist artist) {
        return pictureRepository.findAllByArtist(artist);
    }

    @Override
    public List<Picture> findAllByArtistCredentialLogin(String login) {
        return pictureRepository.findAllByArtistCredentialLogin(login);
    }
}
