package com.smogorzhevskiy.repository;

import com.smogorzhevskiy.entities.Direction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by User on 19.04.16.
 */
@Repository
public interface DirectionRepository extends JpaRepository<Direction,Integer> {

    Direction findByName(String name);
}
