package io.jc.customer.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.jc.customer.errorHandler.CustomerException;
import io.jc.customer.errorHandler.CustomerNotFoundException;
import io.jc.customer.repo.Customer;
import io.jc.customer.repo.CustomerRepository;
import io.jc.customer.service.CustomerService;

@RestController
@RequestMapping("customer-service")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@RequestMapping(value = "customer", method = RequestMethod.POST, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public String create(@RequestBody Customer customer) {

		customerService.createCustomer(customer);

		return "Customer Created";

	}

	@GetMapping(path = "/customers", produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<Customer> retrieveAllCustomers() throws CustomerException, CustomerNotFoundException {
		List<Customer> cust = new ArrayList<Customer>();
		try {
			cust = customerService.getCustomers();

			if (cust.isEmpty()) {
				throw new CustomerNotFoundException();
			}

		} catch (CustomerNotFoundException e) {
			throw new CustomerNotFoundException("No Customers are available in the table");
		}

		catch (Exception e) {
			throw new CustomerException("Exception while retrieving Customer Details ", e);
		}
		return cust;
	}

	@GetMapping(path = "/customer/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public Customer retrieveStudent(@PathVariable Long id) throws CustomerNotFoundException, CustomerException {
		Optional<Customer> customer;
		try {
			customer = customerService.getCustomer(id);
			if (!customer.isPresent()) {
				throw new CustomerNotFoundException();
			}
		} catch (CustomerNotFoundException e) {
			throw new CustomerNotFoundException("Customer of id:" + id + " is not available in the table");
		} catch (Exception e) {
			throw new CustomerException("Exception while retrieving Customer Detail ", e);
		}
		return customer.get();
	}
}
