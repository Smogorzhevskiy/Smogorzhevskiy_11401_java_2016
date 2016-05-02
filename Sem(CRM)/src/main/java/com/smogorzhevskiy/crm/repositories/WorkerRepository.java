package com.smogorzhevskiy.crm.repositories;

import com.smogorzhevskiy.crm.entities.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by User on 19.04.16.
 */
@Repository
public interface WorkerRepository extends JpaRepository<Worker,Integer>{
    //language=SQL
    @Query("SELECT NAME FROM worker w WHERE w.name= :name")
    Worker findByName(@Param("name") String name);
}
