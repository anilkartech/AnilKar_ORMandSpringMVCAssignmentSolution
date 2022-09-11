package com.greatLearning.springMVC.dao;

import java.util.List;
import com.greatLearning.springMVC.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class CustomerDAOImpl implements CustomerDAO {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void saveCustomer(Customer cust) {
		Session session = this.sessionFactory.openSession();
		session.beginTransaction();
		session.save(cust);
		session.getTransaction().commit();
		session.close();

	}

	@Override
	public void updateCustomer(Customer cust) {
		Session session = this.sessionFactory.openSession();
		session.beginTransaction();
		session.update(cust);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public List<Customer> getAllCustomers() {
		Session session = this.sessionFactory.openSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Customer> CustomerList = session.createQuery("From Customer").list();
		session.getTransaction().commit();
		return CustomerList;
	}

	@Override
	public Customer getCustomerById(int id) {
		Session session = this.sessionFactory.openSession();
		session.beginTransaction();
		Customer customer = (Customer) session.load(Customer.class, id);
		session.getTransaction().commit();
		return customer;
	}

	@Override
	public void deleteCustomer(int id) {
		Session session = this.sessionFactory.openSession();
		session.beginTransaction();
		Customer customer = (Customer) session.get(Customer.class, id);
		session.delete(customer);
		session.getTransaction().commit();
		session.close();

	}

}
