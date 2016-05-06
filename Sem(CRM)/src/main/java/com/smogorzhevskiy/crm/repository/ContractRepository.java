package com.smogorzhevskiy.crm.repository;

import com.smogorzhevskiy.crm.entities.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by User on 19.04.16.
 */
@Repository
public interface ContractRepository extends JpaRepository<Contract,Integer> {

    //language=SQL
    @Query("SELECT NAME FROM contract c WHERE c.name= :name")
    Contract findByName(@Param("name") String name);
}
