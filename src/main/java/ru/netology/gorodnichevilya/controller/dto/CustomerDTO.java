package ru.netology.gorodnichevilya.controller.dto;

import lombok.Data;
import ru.netology.gorodnichevilya.domain.Customer;

@Data
public class CustomerDTO {
	private final int id;
	private final String name;

	public static CustomerDTO customerDTO(Customer customer) {
		return new CustomerDTO(customer.getId(), customer.getName());
	}

//	@Override
//	public int hashCode() {
//		return Objects.hash(id, name);
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj) return true;
//		if (obj == null || getClass() != obj.getClass()) return false;
//		ClientDTO clientDTO = (ClientDTO) obj;
//		return id == clientDTO.id && Objects.equals(name, clientDTO.name);
//	}
//
//	public ClientDTO(int id, String name) {
//		this.id = id;
//		this.name = name;
//	}
//
//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
}
