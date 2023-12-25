package ru.netology.gorodnichevilya.service;

import org.springframework.stereotype.Component;

@Component
public class ClientService {
	private AvatarsService avatarsService;

	public ClientService(AvatarsService avatarsService) {
		this.avatarsService = avatarsService;
	}

	public String getClient(){
		return "Client name " + avatarsService.getAvatar();
	}
}
