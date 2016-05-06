package com.smogorzhevskiy.repository;

import com.smogorzhevskiy.entities.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by User on 19.04.16.
 */
@Repository
public interface ContractRepository extends JpaRepository<Contract,Integer> {

//
//    List<Contract> findAll();
//
//    Contract findOneByName(String name);
//
//    Contract findOneById(Artist id);
}
