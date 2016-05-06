package com.smogorzhevskiy.service;

import com.smogorzhevskiy.entities.Worker;

import java.util.List;

/**
 * Created by User on 19.04.16.
 */
public interface WorkerService {
    Worker addWorker(Worker gallery);
    void deleteWorker(Integer id);
    Worker getByNameWorker(String name);
    List<Worker> getAllWorkers();
}
