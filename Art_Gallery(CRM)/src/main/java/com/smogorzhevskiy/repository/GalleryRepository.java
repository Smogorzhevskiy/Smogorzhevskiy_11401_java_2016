package com.smogorzhevskiy.repository;

import com.smogorzhevskiy.entities.Gallery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by User on 19.04.16.
 */
@Repository
public interface GalleryRepository extends JpaRepository<Gallery,Integer> {

    List<Gallery> findAll();

    Gallery findOneByAddress(String address);

    Gallery findOneByName(String name);

    Gallery findOneById(Long id);
//    //language=SQL
//    @Query("SELECT NAME FROM gallery c WHERE c.name= :name")
//    Gallery findByName(@Param("name") String name);
}
