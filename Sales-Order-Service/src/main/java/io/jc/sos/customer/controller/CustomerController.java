package io.jc.sos.customer.controller;

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

import io.jc.sos.customer.repo.CustomerSOS;
import io.jc.sos.customer.service.SalesOrderService;
import io.jc.sos.errorHandler.SalesOrderException;
import io.jc.sos.errorHandler.SalesOrderNotFoundException;

@RestController
@RequestMapping("sales-order-service")
public class SalesOrderServiceController {

	@Autowired
	private SalesOrderService sosService;

	@RequestMapping(value = "sales-order", method = RequestMethod.POST, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public String create(@RequestBody CustomerSOS cust) {

		sosService.createCustomerSOS(cust);

		return "SalesOrder Created";

	}

	@GetMapping(path = "/sales-orders", produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<CustomerSOS> retrieveAllSalesOrders() throws SalesOrderException, SalesOrderNotFoundException {
		List<CustomerSOS> sos = new ArrayList<CustomerSOS>();
		try {
			sos = sosService.getCustomerSOSs();

			if (sos.isEmpty()) {
				throw new SalesOrderNotFoundException();
			}

		} catch (SalesOrderNotFoundException e) {
			throw new SalesOrderNotFoundException("No SalesOrders are available in the table");
		}

		catch (Exception e) {
			throw new SalesOrderException("Exception while retrieving SalesOrder Details ", e);
		}
		return sos;
	}

	@GetMapping(path = "/sales-order/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public CustomerSOS retrieveStudent(@PathVariable Long id) throws SalesOrderNotFoundException, SalesOrderException {
		Optional<CustomerSOS> sos;
		try {
			sos = sosService.getCustomerSOS(id);
			if (!sos.isPresent()) {
				throw new SalesOrderNotFoundException();
			}
		} catch (SalesOrderNotFoundException e) {
			throw new SalesOrderNotFoundException("SalesOrder of id:" + id + " is not available in the table");
		} catch (Exception e) {
			throw new SalesOrderException("Exception while retrieving SalesOrder Detail ", e);
		}
		return sos.get();
	}
}
