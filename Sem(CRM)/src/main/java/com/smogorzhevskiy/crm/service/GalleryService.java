package com.smogorzhevskiy.crm.service;

import com.smogorzhevskiy.crm.entities.Gallery;
import com.sun.tools.javac.util.List;

/**
 * Created by User on 19.04.16.
 */
public interface GalleryService {
    Gallery addGallery(Gallery gallery);
    void delete(Integer id);
    Gallery getByName(String name);
    Gallery editGallery(Gallery bank);
    List<Gallery> getAll();
}
