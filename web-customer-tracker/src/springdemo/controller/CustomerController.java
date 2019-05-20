package springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import springdemo.entity.Customer;
import springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;

	@GetMapping("/list")
	public String listCustomer(Model theModel) {
		
		// get customers from the dao
		List<Customer> theCustomers=customerService.getCustomers();
		
		
		//add the customers to the model
		theModel.addAttribute("customers", theCustomers);
	
		return "list-customers";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		Customer theCustomer = new Customer();
		
		theModel.addAttribute("customer", theCustomer);
		
		
		
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer (@ModelAttribute("customer") Customer theCustomer) {
		customerService.saveCustomer(theCustomer);
		return "redirect:/customer/list";
	}
	
	@GetMapping("/showFormUpdate")
	public String showFormUpdate(@RequestParam("customerId") int theId, Model theModel) {
		//get the customer from the service
		Customer theCustomer = customerService.getCustomer(theId);
		//set customer as a model attribute to pre-populate hte form
		theModel.addAttribute("customer", theCustomer);
		//send over to out form
		
		
		return "customer-form";
		
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int theId) {
		customerService.deleteCustomer(theId);
		return "redirect:/customer/list";
		
	}
	
	@GetMapping("/search")
	public String searchCustomer(@RequestParam("theSearchName")String theSearchName, Model theModel) {
		
		List<Customer> theCustomers=customerService.searchCustomer(theSearchName);
		theModel.addAttribute("customers", theCustomers);
		
		return "list-customers";
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
