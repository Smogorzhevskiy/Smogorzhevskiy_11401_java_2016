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
        return galleryRepository.findAll();
    }

    @Override
    public Gallery findOneByAddress(String address) {
        return galleryRepository.findOneByAddress(address);
    }

    @Override
    public Gallery findOneByName(String name) {
        return galleryRepository.findOneByName(name);
    }

    @Override
    public Gallery findOneById(Integer id) {
        return galleryRepository.findOneById(id);
    }
}
