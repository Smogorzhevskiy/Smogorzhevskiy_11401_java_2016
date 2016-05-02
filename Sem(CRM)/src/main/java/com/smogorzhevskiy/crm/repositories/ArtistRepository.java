package com.smogorzhevskiy.crm.repositories;

import com.smogorzhevskiy.crm.entities.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by User on 19.04.16.
 */
@Repository
public interface ArtistRepository extends JpaRepository<Artist,Integer> {
    @Query("select a from Artist a where a.name = :name")
    Artist findByName(@Param("name") String name);
}
