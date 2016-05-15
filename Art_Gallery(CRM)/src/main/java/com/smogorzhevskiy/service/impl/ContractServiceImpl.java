package com.smogorzhevskiy.service.impl;

import com.smogorzhevskiy.entities.Contract;
import com.smogorzhevskiy.forms.ContractCreationForm;
import com.smogorzhevskiy.repository.ArtistRepository;
import com.smogorzhevskiy.repository.ContractRepository;
import com.smogorzhevskiy.repository.GalleryRepository;
import com.smogorzhevskiy.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by User on 21.04.16.
 */
@Service
public class ContractServiceImpl implements ContractService {
    @Autowired
    private ContractRepository contractRepository;

    @Autowired
    private GalleryRepository galleryRepository;

    @Autowired
    private ArtistRepository artistRepository;


    @Transactional
    public void createContract(ContractCreationForm form) {
        Contract contract = new Contract();
        contract.setGallery(galleryRepository.findOneByName(form.getGallery()));
        contract.setArtist(artistRepository.findOneByCredentialLogin(form.getArtist()));
        contractRepository.save(contract);

    }
    @Override
    public Contract findOneById(Integer id) {
        return contractRepository.findOneById(id);
    }

//    @Override
//    public Contract findContractByArtist(String name) {
//        return contractRepository.findByOneArtistId(name);
//    }

    @Override
    public List<Contract> getAll() {
        return contractRepository.findAll();
    }


}