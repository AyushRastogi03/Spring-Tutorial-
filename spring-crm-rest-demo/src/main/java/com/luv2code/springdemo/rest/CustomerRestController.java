package com.luv2code.springdemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRestController {
     
	//autowire the customerservice
	
	@Autowired
	private CustomerService customerService ;
	//add mapping for get/customers
	
	@GetMapping("/customers")
	public List<Customer> getCustomers(){
		
		return customerService.getCustomers();
	}
	
	
	@GetMapping("/customers/{customerId}")
	public Customer getCustomer(@PathVariable int customerId) {
		 
		Customer thecust = customerService.getCustomer(customerId);
		
		if(thecust==null) {
			throw new CustomerNotFoundException("Customer id not found -"+ customerId);
			
		}
		
		return thecust ;
	}
	
	@PostMapping("/customers")
	public Customer addCustomer(@RequestBody Customer thecust)
	{   
		//also just in case the pass an id in json .. set id to 0 
		// this is force a save to new item -- instead of update 
		thecust.setId(0);
	     customerService.saveCustomer(thecust);
	     
		return thecust;
	}
	
	@PutMapping("/customers")
	public Customer updateCustomer(@RequestBody Customer thecust) {
		customerService.saveCustomer(thecust);
		
		return thecust ;
	}
	@DeleteMapping("/customers/{cust}")
	public String deleteCustomer(@PathVariable int cust) {
		
		Customer temp = customerService.getCustomer(cust);
		
		if(temp == null) {
			throw new CustomerNotFoundException("Customer id not Found - " + cust);
			
		}
	   
		customerService.deleteCustomer(cust);
		
		return "Deleted Customer Id - " + cust ;
	}
	
}
