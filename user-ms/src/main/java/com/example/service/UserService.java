package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.entities.Contacts;
import com.example.entities.User;
import com.example.repository.UserRepository;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.micrometer.tracing.annotation.NewSpan;

@Service
public class UserService {

	@Autowired
	UserRepository repo;

//	@Autowired
//	RestTemplate restTemplate;
//	
	@Autowired
	ContactsClient client;

	 @NewSpan("getUserId")
	@CircuitBreaker(name="userService", fallbackMethod="getUserByIdFallback")
	public User getUserById(int userId)
	{
		User user=repo.findById(userId).get();
		//List<Contacts> contacts=restTemplate.getForObject("http://contacts-ms/api/contacts/"+userId, List.class);
		List<Contacts> contacts=client.getContactsByUserId(userId);
		user.setContact(contacts);
		return user;
	}
	 
	 
	 @NewSpan("getAllUsers")
	public List<User> getAllUsers() {

		return repo.findAll();
	}
	
	public User getUserByIdFallback(int userId ,Throwable t)
	{
	  System.out.println("Service currently unavailable, Please try again later :( ");	
	  return new User();
	}

}
