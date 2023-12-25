package ru.netology.gorodnichevilya.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Component
public class AccountService {
	@PostConstruct
	public void init(){
		System.out.println("Вызван init AccountService");
	}

	public String getAccount(){
		return "Account";
	}
}
