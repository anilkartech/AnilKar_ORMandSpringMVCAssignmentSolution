package com.greatLearning.springMVC.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatLearning.springMVC.entity.Customer;
import com.greatLearning.springMVC.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	CustomerService customerService;

	public CustomerService getCustomerService() {
		return customerService;
	}

	@Autowired
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String viewCustomerList(Model model) {
		List<Customer> customers = customerService.getAllCustomers();
		model.addAttribute("customerList", customers);
		return "view-customer-list";
	}

	@RequestMapping("/showFormForAdd")
	public String showFormForAddCustomer(Model model) {
		model.addAttribute("customer", new Customer());
		return "customer-add-form";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveNewCustomerInDatabase(@ModelAttribute("customer") Customer cust) {
		customerService.saveCustomer(cust);
		return "redirect:/customer/list";
	}

	@RequestMapping(value = "/showFormForUpdate")
	public String showFormForUpdateCustomer(@RequestParam("customerId") int id, Model model) {
		Customer cust = customerService.getCustomerById(id);
		model.addAttribute("customer", cust);
		return "customer-edit-form";
	}

	@RequestMapping(value = "/editsave", method = RequestMethod.POST)
	public String saveEditedCustomerInDatabase(@ModelAttribute("customer") Customer cust) {
		System.out.println("edit customer controller:" + cust);
		customerService.updateCustomer(cust);
		return "redirect:/customer/list";
	}

	@RequestMapping(value = "/deleteCustomer/{id}", method = RequestMethod.GET)
	public String deleteCustomerFromDatabase(@PathVariable int id) {
		customerService.deleteCustomer(id);
		return "redirect:/customer/list";
	}
}
