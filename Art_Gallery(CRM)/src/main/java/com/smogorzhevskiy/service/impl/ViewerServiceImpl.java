package com.smogorzhevskiy.service.impl;

import com.smogorzhevskiy.entities.Credential;
import com.smogorzhevskiy.entities.Viewer;
import com.smogorzhevskiy.forms.ViewerRegistrationForm;
import com.smogorzhevskiy.repository.CredentialRepository;
import com.smogorzhevskiy.repository.ViewerRepository;
import com.smogorzhevskiy.service.ViewerService;
import com.smogorzhevskiy.utility.transformers.TransformFromRegForm;
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
    @Autowired
    private CredentialRepository credentialRepository;
    @Override
    public void createViewer(ViewerRegistrationForm form) {
        Credential credential = TransformFromRegForm.transformViewerFormCredential(form);
        credentialRepository.save(credential);
        Viewer viewer = new Viewer();
        viewer.setName(form.getName());
        viewer.setCredential(credential);
        viewer.setSurname(form.getSurname());
        viewer.setPhoneNumber(form.getPhone());
        viewerRepository.save(viewer);
    }

    @Override
    public void deleteViewer(Integer id) {
        viewerRepository.delete(id);

    }

    @Override
    public Viewer findOneByName(String name) {

        return viewerRepository.findOneByName(name);
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
