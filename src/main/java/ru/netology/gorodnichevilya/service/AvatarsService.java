package ru.netology.gorodnichevilya.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class AvatarsService {
	public String getAvatar(){
		return "Avatar";
	}
}
