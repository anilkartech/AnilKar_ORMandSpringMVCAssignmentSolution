package com.greatLearning.springMVC.dao;

import java.util.List;

import com.greatLearning.springMVC.entity.Customer;

public interface CustomerDAO {

	public void saveCustomer(Customer cust);

	public void updateCustomer(Customer cust);

	public List<Customer> getAllCustomers();

	public Customer getCustomerById(int id);

	public void deleteCustomer(int id);
}
