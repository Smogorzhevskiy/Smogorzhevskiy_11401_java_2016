package com.smogorzhevskiy.crm.service;

import com.smogorzhevskiy.crm.entities.Contract;
import com.sun.tools.javac.util.List;

/**
 * Created by User on 19.04.16.
 */
public interface ContractService {
    Contract addContract(Contract gallery);
    void delete(Integer id);
    Contract getByNameContract(String name);
    List<Contract> getAllContracts();
}
