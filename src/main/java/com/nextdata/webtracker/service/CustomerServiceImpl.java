package com.nextdata.webtracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nextdata.webtracker.dao.CustomerDao;
import com.nextdata.webtracker.model.Customer;


@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;

	@Override
	@Transactional
	public List<Customer> getCustomers() {
		return customerDao.getCustomers();
	}

	@Override
	@Transactional
	public void saveCustomer(Customer customer) {
		customerDao.saveCustomer(customer);
		
	}

	@Override
	@Transactional
	public void updateCustomer(Customer customer) {
		customerDao.updateCustomer(customer);
	}

	@Override
	@Transactional
	public Customer getCustomer(Integer customerId) {
		Customer customer = customerDao.getCustomer(customerId);
		return customer;
	}

	@Override
	@Transactional
	public void deleteCustomer(Integer customerId) {
		customerDao.deleteCustomer(customerId);
		
	}

}
