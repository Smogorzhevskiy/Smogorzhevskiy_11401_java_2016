package com.smogorzhevskiy.service;

import com.smogorzhevskiy.entities.Direction;

import java.util.List;

/**
 * Created by User on 19.04.16.
 */
public interface DirectionService {
    Direction addDirection(Direction gallery);
    List<Direction> getAllDirections();

}
