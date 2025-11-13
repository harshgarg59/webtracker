package com.nextdata.webtracker.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nextdata.webtracker.model.Customer;
import com.nextdata.webtracker.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		StringTrimmerEditor editor = new StringTrimmerEditor(true);
		binder.registerCustomEditor(String.class, editor);
	}

	@GetMapping("/list")
	public String listCustomer(Model model) {
		List<Customer> customers = customerService.getCustomers();
		model.addAttribute("customers", customers);
		return "list-customer";
	}

	@GetMapping("/add")
	public String addCustomer(Model model) {
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		return "customer-form";
	}

	@PostMapping("/save")
	public String saveCustomer(@Valid @ModelAttribute(name = "customer") Customer customer,
			BindingResult bindingResul) {
		if (bindingResul.hasErrors()) {
			return "customer-form";
		} else {
			customerService.saveCustomer(customer);
			return "redirect:/customer/list";
		}
	}

	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam(name = "customerId") Integer customerId) {
		customerService.deleteCustomer(customerId);
		return "redirect:/customer/list";
	}

	@GetMapping("/get")
	public String getCustomer(@RequestParam(name = "customerId") Integer customerId, Model model) {
		Customer customer = customerService.getCustomer(customerId);
		model.addAttribute("customer", customer);
		return "customer-form";
	}

}
