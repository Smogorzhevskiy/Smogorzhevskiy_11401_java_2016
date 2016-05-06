package com.smogorzhevskiy.service.impl;

import com.smogorzhevskiy.entities.Worker;
import com.smogorzhevskiy.repository.WorkerRepository;
import com.smogorzhevskiy.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by User on 25.04.16.
 */
@Service
public class WorkerServiceImpl implements WorkerService {
    @Autowired
    private WorkerRepository workerRepository;
    @Override
    public Worker addWorker(Worker worker) {
        Worker saveWorker = workerRepository.saveAndFlush(worker);
        return saveWorker;
    }

    @Override
    public void deleteWorker(Integer id) {
        workerRepository.delete(id);

    }

    @Override
    public Worker getByNameWorker(String name) {
//        return workerRepository.findByName(name);
        return null;
    }

    @Override
    public List<Worker> getAllWorkers() {
        return (List<Worker>) workerRepository.findAll();
    }
}
