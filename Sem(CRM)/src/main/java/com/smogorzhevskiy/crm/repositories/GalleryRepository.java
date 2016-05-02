package com.smogorzhevskiy.crm.repositories;

import com.smogorzhevskiy.crm.entities.Gallery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by User on 19.04.16.
 */
@Repository
public interface GalleryRepository extends JpaRepository<Gallery,Integer> {

    //language=SQL
    @Query("SELECT NAME FROM gallery c WHERE c.name= :name")
    Gallery findByName(@Param("name") String name);
}
