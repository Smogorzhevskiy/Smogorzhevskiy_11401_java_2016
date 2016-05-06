package com.smogorzhevskiy.service.impl;

import com.smogorzhevskiy.entities.Contract;
import com.smogorzhevskiy.repository.ContractRepository;
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


    @Override
    public Contract getOneByName(String name) {
        return null;
    }

    @Override
    public Contract findOneById(Integer id) {
        return null;
//        return contractRepository.findOneById(id);
    }

    @Override
    public List<Contract> getAll() {
        return contractRepository.findAll();
    }
}