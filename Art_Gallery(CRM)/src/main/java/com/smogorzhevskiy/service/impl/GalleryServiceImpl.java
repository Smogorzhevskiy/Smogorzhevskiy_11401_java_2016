package com.smogorzhevskiy.service.impl;

import com.smogorzhevskiy.entities.Gallery;
import com.smogorzhevskiy.repository.GalleryRepository;
import com.smogorzhevskiy.service.GalleryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by User on 19.04.16.
 */
@Service
public class GalleryServiceImpl implements GalleryService {

    @Autowired
    private GalleryRepository galleryRepository;

    @Override
    public List<Gallery> findAll() {
        return null;
    }

    @Override
    public Gallery findOneByAddress(String address) {
        return null;
    }

    @Override
    public Gallery findOneByName(String name) {
        return null;
    }

    @Override
    public Gallery findOneById(Long id) {
        return null;
    }
}
