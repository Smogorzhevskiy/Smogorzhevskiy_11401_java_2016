package com.smogorzhevskiy.repository;

import com.smogorzhevskiy.entities.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by User on 19.04.16.
 */
@Repository
public interface ArtistRepository extends JpaRepository<Artist, java.lang.Integer> {
    Artist findByName(String name);
}
