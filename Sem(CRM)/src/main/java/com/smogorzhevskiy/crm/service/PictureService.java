package com.smogorzhevskiy.crm.service;

import com.smogorzhevskiy.crm.entities.Picture;
import com.sun.tools.javac.util.List;

/**
 * Created by User on 19.04.16.
 */
public interface PictureService {
    Picture addPicture(Picture gallery);
    void deletePicture(Integer id);
    Picture getByNamePicture(String name);
    List<Picture> getPicturesByArtist();
    List<Picture> getAllPictures();
}
