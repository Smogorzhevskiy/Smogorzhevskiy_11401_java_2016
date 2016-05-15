package com.smogorzhevskiy.service;

import com.smogorzhevskiy.entities.Contract;
import com.smogorzhevskiy.forms.ContractCreationForm;

import java.util.Date;
import java.util.List;

/**
 * Created by User on 19.04.16.
 */
public interface ContractService {
    void createContract(ContractCreationForm form);
    Contract findOneById(Integer id);
//    Contract findContractByArtist(String name);
    List<Contract> getAll();
}
