package com.smogorzhevskiy.service;

import com.smogorzhevskiy.entities.Viewer;
import com.smogorzhevskiy.forms.ViewerRegistrationForm;

import java.util.List;

/**
 * Created by User on 19.04.16.
 */
public interface ViewerService {

    void createViewer(ViewerRegistrationForm form);

    void deleteViewer(Integer id);
    Viewer findOneByName(String name);
    Viewer editViewer(Viewer bank);
    List<Viewer> getAllViewers();
}
