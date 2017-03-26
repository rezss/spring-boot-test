package com.example.bootstrap;

import com.example.model.Customer;
import com.example.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

public class DatabaseBootstrap implements InitializingBean
{
  private static Logger log = LoggerFactory.getLogger(DatabaseBootstrap.class);

  @Autowired
  CustomerRepository repository;

  @Override
  public void afterPropertiesSet() throws Exception
  {
    if (repository.findByFirstnameAndLastname("Hans", "Peter") == null)
    {
      final Customer customer = new Customer();
      customer.setFirstname("Hans");
      customer.setLastname("Peter");
      repository.save(customer);
      log.info("Hans Peter created");
    }

    log.info("Bootstrap finished");
  }
}
