package com.smogorzhevskiy.repository;

import com.smogorzhevskiy.entities.Viewer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by User on 19.04.16.
 */
@Repository
public interface ViewerRepository extends JpaRepository<Viewer,Integer>{
//    //language=SQL
//    @Query("SELECT NAME FROM viwer c WHERE c.name= :name")
//    Viewer findByName(@Param("name") String name);
}
