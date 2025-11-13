package com.nextdata.webtracker.service;

import java.util.List;

import com.nextdata.webtracker.model.Customer;

public interface CustomerService {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer customer);

	public void updateCustomer(Customer customer);

	public Customer getCustomer(Integer customerId);

	public void deleteCustomer(Integer customerId);

}
