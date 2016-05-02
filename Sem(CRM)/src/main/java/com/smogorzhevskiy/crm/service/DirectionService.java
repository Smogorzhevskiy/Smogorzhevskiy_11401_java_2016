package com.smogorzhevskiy.crm.service;

import com.smogorzhevskiy.crm.entities.Direction;
import com.sun.tools.javac.util.List;

/**
 * Created by User on 19.04.16.
 */
public interface DirectionService {
    Direction addDirection(Direction gallery);
    List<Direction> getAllDirections();

}
