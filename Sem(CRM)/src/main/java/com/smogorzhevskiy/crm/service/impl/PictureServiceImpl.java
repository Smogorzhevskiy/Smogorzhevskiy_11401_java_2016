package com.smogorzhevskiy.crm.service.impl;

import com.smogorzhevskiy.crm.entities.Picture;
import com.smogorzhevskiy.crm.repositories.PictureRepository;
import com.smogorzhevskiy.crm.service.PictureService;
import com.sun.tools.javac.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by User on 21.04.16.
 */
@Service
public class PictureServiceImpl implements PictureService {

    @Autowired
    private PictureRepository pictureRepository;
    @Override
    public Picture addPicture(Picture picture) {
        Picture savePicture = pictureRepository.saveAndFlush(picture);
        return savePicture;
    }

    @Override
    public void deletePicture(Integer id) {
        pictureRepository.delete(id);

    }

    @Override
    public Picture getByNamePicture(String name) {
        return pictureRepository.findByName(name);
    }

    @Override
    public List<Picture> getPicturesByArtist() {
        return null;
    }


    @Override
    public List<Picture> getAllPictures() {
        return (List<Picture>) pictureRepository.findAll();
    }
}
