package com.example.controller;

import com.example.model.Customer;
import com.example.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

@Controller
public class CustomerController
{
  @Autowired
  CustomerRepository repository;

  @RequestMapping(value = "/customers", method = RequestMethod.GET)
  public ModelAndView getCustomers()
  {
    return new ModelAndView("customers")
      .addObject("customers", repository.findAll())
      .addObject("createLink", linkTo(
        methodOn(CustomerController.class).createCustomer(null, null)).withRel("Create"));
  }

  @RequestMapping(value = "/customers/create", method = RequestMethod.POST)
  @Secured({"ROLE_ADMIN"})
  public ModelAndView createCustomer(String firstname, String lastname)
  {
    Customer customer = new Customer();
    customer.setFirstname(firstname);
    customer.setLastname(lastname);
    repository.save(customer);
    return new ModelAndView("created-customer")
      .addObject("overview", linkTo(
        methodOn(CustomerController.class).getCustomers()).withRel("Overview"));
  }
}
