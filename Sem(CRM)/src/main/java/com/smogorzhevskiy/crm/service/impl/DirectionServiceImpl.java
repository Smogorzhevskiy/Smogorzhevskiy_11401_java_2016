package com.smogorzhevskiy.crm.service.impl;

import com.smogorzhevskiy.crm.entities.Direction;
import com.smogorzhevskiy.crm.repositories.DirectionRepository;
import com.smogorzhevskiy.crm.service.DirectionService;
import com.sun.tools.javac.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by User on 21.04.16.
 */
@Service
public class DirectionServiceImpl implements DirectionService {
    @Autowired
    private DirectionRepository directionRepository;

    @Override
    public Direction addDirection(Direction direction) {
        Direction saveDirection = directionRepository.saveAndFlush(direction);
        return saveDirection;
    }

    @Override
    public List<Direction> getAllDirections() {
        return (List<Direction>) directionRepository.findAll();
    }
}
