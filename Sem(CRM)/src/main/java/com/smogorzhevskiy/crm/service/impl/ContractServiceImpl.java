package com.smogorzhevskiy.crm.service.impl;

import com.smogorzhevskiy.crm.entities.Contract;
import com.smogorzhevskiy.crm.repositories.ContractRepository;
import com.smogorzhevskiy.crm.service.ContractService;
import com.sun.tools.javac.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by User on 21.04.16.
 */
@Service
public class ContractServiceImpl implements ContractService {
    @Autowired
    private ContractRepository contractRepository;

    @Override
    public Contract addContract(Contract contract) {
        Contract saveContract = contractRepository.saveAndFlush(contract);
        return saveContract;
    }

    @Override
    public void delete(Integer id) {
        contractRepository.delete(id);

    }

    @Override
    public Contract getByNameContract(String name) {
        return contractRepository.findByName(name);
    }

    @Override
    public List<Contract> getAllContracts() {
        return (List<Contract>) contractRepository.findAll();
    }
}
