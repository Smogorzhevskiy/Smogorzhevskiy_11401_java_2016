package com.smogorzhevskiy.crm.service.impl;

import com.smogorzhevskiy.crm.entities.Viewer;
import com.smogorzhevskiy.crm.repositories.ViewerRepository;
import com.smogorzhevskiy.crm.service.ViewerService;
import com.sun.tools.javac.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by User on 21.04.16.
 */
@Service
public class ViewerServiceImpl implements ViewerService {
    @Autowired
    private ViewerRepository viewerRepository;
    @Override
    public Viewer addViewer(Viewer viewer) {
        Viewer saveViewer = viewerRepository.saveAndFlush(viewer);
        return saveViewer;
    }

    @Override
    public void deleteViewer(Integer id) {
        viewerRepository.delete(id);

    }

    @Override
    public Viewer getByNameViewer(String name) {
        return viewerRepository.findByName(name);
    }

    @Override
    public Viewer editViewer(Viewer viewer) {
        return viewerRepository.saveAndFlush(viewer);
    }

    @Override
    public List<Viewer> getAllViewers() {
        return (List<Viewer>) viewerRepository.findAll();
    }
}
