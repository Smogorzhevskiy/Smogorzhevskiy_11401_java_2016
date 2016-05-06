package com.smogorzhevskiy.service;

import com.smogorzhevskiy.entities.Contract;

import java.util.List;

/**
 * Created by User on 19.04.16.
 */
public interface ContractService {
    Contract getOneByName(String name);
    Contract findOneById(Integer id);
    List<Contract> getAll();
}
