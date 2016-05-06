package com.smogorzhevskiy.service.impl;

import com.smogorzhevskiy.entities.Viewer;
import com.smogorzhevskiy.repository.ViewerRepository;
import com.smogorzhevskiy.service.ViewerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

        return null;
//        return viewerRepository.findByName(name);
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
