package com.example.repository;

import com.example.model.Checkout;
import org.springframework.data.repository.CrudRepository;

public interface CheckoutRepository extends CrudRepository<Checkout, String>
{
}
