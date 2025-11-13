package com.nextdata.webtracker.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nextdata.webtracker.model.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> getCustomers() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Customer> query = currentSession.createQuery("from Customer", Customer.class);
		List<Customer> resultList = query.getResultList();
		return resultList;
	}

	@Override
	public Customer getCustomer(Integer customerId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Customer customer = currentSession.get(Customer.class, customerId);
		return customer;
	}

	@Override
	public void saveCustomer(Customer customer) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(customer);
	}

	@Override
	public void updateCustomer(Customer customer) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.save(customer);
	}

	@Override
	public void deleteCustomer(Integer customerId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Customer customer = currentSession.get(Customer.class, customerId);
		currentSession.delete(customer);
	}

}
