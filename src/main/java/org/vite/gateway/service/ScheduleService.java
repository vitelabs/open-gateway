package org.vite.gateway.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vite.gateway.database.DBFacade;
import org.vite.gateway.schedule.TaskManager;

import javax.annotation.PostConstruct;

@Service
public class ScheduleService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ScheduleService.class);

    @Autowired
    private TaskManager taskManager;

    @Autowired
    private DBFacade database;

    @PostConstruct
    public void init() {

    }
}
