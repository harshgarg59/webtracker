package com.nextdata.webtracker.dao;

import java.util.List;

import com.nextdata.webtracker.model.Customer;

public interface CustomerDao {

	public List<Customer> getCustomers();

	public Customer getCustomer(Integer csutomerId);

	public void saveCustomer(Customer customer);

	public void updateCustomer(Customer customer);

	public void deleteCustomer(Integer customerId);

}
