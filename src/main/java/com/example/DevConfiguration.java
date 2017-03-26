package com.example;

import com.example.bootstrap.DatabaseBootstrap;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
@ConditionalOnClass(name = {"org.h2.Driver"})
public class DevConfiguration
{
  @Bean
  public DatabaseBootstrap databaseBootstrap()
  {
    return new DatabaseBootstrap();
  }
}
