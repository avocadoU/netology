package ru.netology.gorodnichevilya.service;

import org.springframework.beans.factory.annotation.Autowired;
import ru.netology.gorodnichevilya.domain.Customer;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

//@SpringBootTest
public class CustomerServiceTest extends OperationHistoryApiApplicationTest {
	@Autowired
	CustomerService customerService;

	@Test
	public void getCustomerTest(){
		List<Customer> customers = customerService.getCustomers();
		Customer customer1 = customers.get(0);
		Customer customer2 = customers.get(1);
		assertEquals(1, customer1.getId());
		assertEquals("Spring", customer1.getName());
		assertEquals(2, customer2.getId());
		assertEquals("Spring Boot", customer2.getName());
		assertEquals(3, customers.size());
	}
}
