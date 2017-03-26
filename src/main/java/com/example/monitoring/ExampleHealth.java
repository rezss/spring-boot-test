package com.example.monitoring;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

@Component
public class ExampleHealth implements HealthIndicator
{
  @Override
  public Health health() {
    return new Health.Builder().status(Status.UP).build();
  }
}
