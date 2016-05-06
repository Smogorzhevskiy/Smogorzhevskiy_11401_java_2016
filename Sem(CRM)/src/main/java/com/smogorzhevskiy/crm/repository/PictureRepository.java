package com.smogorzhevskiy.crm.repository;

import com.smogorzhevskiy.crm.entities.Picture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by User on 19.04.16.
 */
@Repository
public interface PictureRepository extends JpaRepository<Picture,Integer> {
    //language=SQL
    @Query("SELECT NAME FROM picture p WHERE p.name = :NAME ")
    Picture findByName(@Param("name") String name);
}
