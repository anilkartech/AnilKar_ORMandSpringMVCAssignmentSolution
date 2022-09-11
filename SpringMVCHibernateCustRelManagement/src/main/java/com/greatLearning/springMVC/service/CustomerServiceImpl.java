package com.greatLearning.springMVC.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.greatLearning.springMVC.dao.CustomerDAO;
import com.greatLearning.springMVC.entity.Customer;

public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO customerDAO;

	public CustomerDAO getCustomerDAO() {
		return customerDAO;
	}

	public void setCustomerDAO(CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}

	@Override
	public void saveCustomer(Customer cust) {
		this.customerDAO.saveCustomer(cust);
	}

	@Override
	public void updateCustomer(Customer cust) {
		System.out.println("edit customer service:" + cust);
		this.customerDAO.updateCustomer(cust);
	}

	@Override
	public List<Customer> getAllCustomers() {
		return this.customerDAO.getAllCustomers();
	}

	@Override
	public Customer getCustomerById(int id) {
		return this.customerDAO.getCustomerById(id);
	}

	@Override
	public void deleteCustomer(int id) {
		this.customerDAO.deleteCustomer(id);
	}

}
