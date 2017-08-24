package com.wylie.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Value("${server}")
	public String port;
	
	public String getPort(){
		return this.port;
	}
}
