package com.greatLearning.springMVC.service;

import java.util.List;
import com.greatLearning.springMVC.entity.Customer;

public interface CustomerService {
	public void saveCustomer(Customer cust);

	public void updateCustomer(Customer cust);

	public List<Customer> getAllCustomers();

	public Customer getCustomerById(int id);

	public void deleteCustomer(int id);
}
