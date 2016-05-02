package com.smogorzhevskiy.crm.service;

import com.smogorzhevskiy.crm.entities.Viewer;
import com.sun.tools.javac.util.List;

/**
 * Created by User on 19.04.16.
 */
public interface ViewerService {
    Viewer addViewer(Viewer gallery);
    void deleteViewer(Integer id);
    Viewer getByNameViewer(String name);
    Viewer editViewer(Viewer bank);
    List<Viewer> getAllViewers();
}
