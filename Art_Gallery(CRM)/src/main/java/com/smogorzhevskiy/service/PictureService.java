package com.smogorzhevskiy.service;

import com.smogorzhevskiy.entities.Artist;
import com.smogorzhevskiy.entities.Picture;
import com.smogorzhevskiy.forms.PictureCreationForm;

import java.util.List;

/**
 * Created by User on 19.04.16.
 */
public interface PictureService {
    Picture createPicture(PictureCreationForm form);
    void deletePicture(java.lang.Integer id);
    Picture findOneById(java.lang.Integer id);
    List<Picture> findAllByArtist(Artist artist);
    List<Picture> findAllByArtistCredentialLogin(String login);
}
