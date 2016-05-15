package com.smogorzhevskiy.repository;

import com.smogorzhevskiy.entities.Artist;
import com.smogorzhevskiy.entities.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Created by User on 19.04.16.
 */
@Repository
public interface ContractRepository extends JpaRepository<Contract,Integer> {

//    Artist findOneByArtist_id(String name);
    List<Contract> findAll();

    Contract findOneById(Integer id);

}
