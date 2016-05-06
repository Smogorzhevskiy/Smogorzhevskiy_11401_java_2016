package com.smogorzhevskiy.service;

import com.smogorzhevskiy.entities.Contract;

import java.util.Date;
import java.util.List;

/**
 * Created by User on 19.04.16.
 */
public interface ContractService {
    Contract findOneById(Integer id);
    Contract findContractByArtist(String name);
    List<Contract> getAll();
    List<Contract> findAllContractByDateOfConclusion(Date dateOfConclusion);
}
