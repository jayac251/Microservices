package io.jc.sos.customer.service;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.jc.sos.customer.repo.CustomerSOS;
import io.jc.sos.customer.repo.SOSRepository;

/*
 * Service Class for SalesOrder
 */
@Service
public class SalesOrderService {

	private final static Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	@Autowired
	private SOSRepository sosRepository;

	@PostConstruct
	void initialize() {
		CustomerSOS cust1 = new CustomerSOS("Ramu", "Yadav", "123@one.com");
		CustomerSOS cust2 = new CustomerSOS("Suresh", "Yadav", "234@two.com");
		sosRepository.save(cust1);
		sosRepository.save(cust2);
	}

	/**
	 * Gets List of CustomerSOSs from CustomerSOS Table
	 * 
	 * @return CustomerSOS List
	 * @throws Exception 
	 */
	public List<CustomerSOS> getCustomerSOSs() throws Exception {
		List<CustomerSOS> cust = new ArrayList<CustomerSOS>();
		try {
			cust = sosRepository.findAll();
		} catch (Exception e) {
			log.error("CustomerSOS Repository Returned no records");
			throw new Exception(e);
		}
		return cust;
	}

	/**
	 * Gets CustomerSOS of particular id from CustomerSOS Table
	 * 
	 * @return CustomerSOS
	 */
	public Optional<CustomerSOS> getCustomerSOS(Long id) {
		Optional<CustomerSOS> custSos;
		custSos=	sosRepository.findById(id);
		if(custSos.isPresent()) {
			log.info("CustomerSOS is present , id {}",id);
		}
		return custSos;
	}

	/**
	 * Creates a new CustomerSOS
	 */
	public void createCustomerSOS(CustomerSOS custSos) {
		sosRepository.save(custSos);
		log.info("CustomerSOS Created");

	}

}
