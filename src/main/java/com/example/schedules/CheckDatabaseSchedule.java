package com.example.schedules;

import com.example.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

public class CheckDatabaseSchedule
{
  private static Logger log = LoggerFactory.getLogger(CheckDatabaseSchedule.class);

  @Autowired
  CustomerRepository repository;

  @Scheduled(initialDelay = 1000, fixedDelay = 10000)
  public void run()
  {
    log.info("Running database check");

    if (repository.count() <= 0)
      log.warn("Database is empty for customers");
  }
}
