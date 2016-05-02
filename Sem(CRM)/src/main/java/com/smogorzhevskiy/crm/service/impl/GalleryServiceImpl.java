package com.smogorzhevskiy.crm.service.impl;

import com.smogorzhevskiy.crm.entities.Gallery;
import com.smogorzhevskiy.crm.repositories.GalleryRepository;
import com.smogorzhevskiy.crm.service.GalleryService;
import com.sun.tools.javac.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by User on 19.04.16.
 */
@Service
public class GalleryServiceImpl implements GalleryService {

    @Autowired
    private GalleryRepository galleryRepository;
    @Override
    public Gallery addGallery(Gallery gallery) {
        Gallery saveGallery = galleryRepository.saveAndFlush(gallery);
        return saveGallery;
    }

    @Override
    public void delete(Integer id) {
        galleryRepository.delete(id);
    }

    @Override
    public Gallery getByName(String name) {
        return galleryRepository.findByName(name);
    }

    @Override
    public Gallery editGallery(Gallery gallery) {
        return galleryRepository.saveAndFlush(gallery);
    }

    @Override
    public List<Gallery> getAll() {
        return (List<Gallery>) galleryRepository.findAll();
    }
}
