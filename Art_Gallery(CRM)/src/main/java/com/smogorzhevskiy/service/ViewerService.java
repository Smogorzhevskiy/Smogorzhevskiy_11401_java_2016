package com.smogorzhevskiy.service;

import com.smogorzhevskiy.entities.Viewer;

import java.util.List;

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
