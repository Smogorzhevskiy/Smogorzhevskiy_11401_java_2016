package com.smogorzhevskiy.service.impl;

import com.smogorzhevskiy.entities.Contract;
import com.smogorzhevskiy.repository.ContractRepository;
import com.smogorzhevskiy.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by User on 21.04.16.
 */
@Service
public class ContractServiceImpl implements ContractService {
    @Autowired
    private ContractRepository contractRepository;

    @Override
    public Contract findOneById(Integer id) {
        return contractRepository.findOneById(id);
    }

    @Override
    public Contract findContractByArtist(String name) {
        return contractRepository.findContractByArtist(name);
    }

    @Override
    public List<Contract> getAll() {
        return contractRepository.findAll();
    }

    @Override
    public List<Contract> findAllContractByDateOfConclusion(Date dateOfConclusion) {
        return contractRepository.findAllContractByDateOfConclusion(dateOfConclusion);
    }
}