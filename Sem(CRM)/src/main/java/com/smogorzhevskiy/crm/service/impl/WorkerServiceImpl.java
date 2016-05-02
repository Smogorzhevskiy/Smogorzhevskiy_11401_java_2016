package com.smogorzhevskiy.crm.service.impl;

import com.smogorzhevskiy.crm.entities.Worker;
import com.smogorzhevskiy.crm.repositories.WorkerRepository;
import com.smogorzhevskiy.crm.service.WorkerService;
import com.sun.tools.javac.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return workerRepository.findByName(name);
    }

    @Override
    public List<Worker> getAllWorkers() {
        return (List<Worker>) workerRepository.findAll();
    }
}
