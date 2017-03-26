package com.example.repository;

import com.example.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long>
{
  Customer findByFirstnameAndLastname(String firstname, String lastname);
}
