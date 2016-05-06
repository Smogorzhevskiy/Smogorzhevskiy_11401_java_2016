package com.smogorzhevskiy.service.impl;

import com.smogorzhevskiy.entities.Direction;
import com.smogorzhevskiy.repository.DirectionRepository;
import com.smogorzhevskiy.service.DirectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
