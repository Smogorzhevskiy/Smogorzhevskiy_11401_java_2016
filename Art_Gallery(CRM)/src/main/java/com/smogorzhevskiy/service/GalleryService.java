package com.smogorzhevskiy.service;

import com.smogorzhevskiy.entities.Gallery;

import java.util.List;

/**
 * Created by User on 19.04.16.
 */
public interface GalleryService {
    List<Gallery> findAll();

    Gallery findOneByAddress(String address);

    Gallery findOneByName(String name);

    Gallery findOneById(Integer id);
}
