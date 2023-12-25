package ru.netology.gorodnichevilya.controller;

import ru.netology.gorodnichevilya.domain.Customer;
import ru.netology.gorodnichevilya.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.gorodnichevilya.controller.dto.CustomerDTO;
import ru.netology.gorodnichevilya.controller.dto.GetClientsResponse;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api/customers")
public class CustomerController {
	private final CustomerService customerService;

	@GetMapping
	public GetClientsResponse getClients(){
		List<Customer> customers = customerService.getCustomers();
		List<CustomerDTO> customerDTOS = new ArrayList<>();
		for (Customer customer: customers){
			CustomerDTO customerDTO = new CustomerDTO(customer.getId(), customer.getName());
			customerDTOS.add(customerDTO);
		}
		return new GetClientsResponse(customerDTOS);
	}

	@GetMapping("/{id}")
	public CustomerDTO getCustomer(@PathVariable(name = "id") int customerID){
		return customerService.getCustomers().stream()
				.filter(customer -> customer.getId() == customerID)
				.map(customer -> new CustomerDTO(customer.getId(), customer.getName()))
				.findFirst().orElse(null);
	}
}
