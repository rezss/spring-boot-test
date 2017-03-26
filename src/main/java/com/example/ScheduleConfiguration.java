package com.example;

import com.example.schedules.CheckDatabaseSchedule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
public class ScheduleConfiguration
{
  @Bean
  public CheckDatabaseSchedule checkDatabaseSchedule()
  {
    return new CheckDatabaseSchedule();
  }
}
