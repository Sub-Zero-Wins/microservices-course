package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.Contacts;
import com.example.service.ContactsService;

@RestController
@RequestMapping("/api/contacts")
public class ContactsController {

	@Autowired
	ContactsService service;
	
	@GetMapping("/{userId}")
	public List<Contacts> getByUserId(@PathVariable int userId)
	{
		return service.getContactsByUserId(userId);
	}
	@GetMapping("/all")
	public List<Contacts> getAllContacts()
	{
		return service.getAllContacts();
	}
}
