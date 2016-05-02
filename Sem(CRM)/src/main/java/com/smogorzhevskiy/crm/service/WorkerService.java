package com.smogorzhevskiy.crm.service;

import com.smogorzhevskiy.crm.entities.Worker;
import com.sun.tools.javac.util.List;

/**
 * Created by User on 19.04.16.
 */
public interface WorkerService {
    Worker addWorker(Worker gallery);
    void deleteWorker(Integer id);
    Worker getByNameWorker(String name);
    List<Worker> getAllWorkers();
}
