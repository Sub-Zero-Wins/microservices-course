package com.example.service;

import java.util.Collections;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.entities.Contacts;

@FeignClient(name="contacts-ms")
public interface ContactsClient 
{
	@GetMapping("/api/contacts/{userId}")
	List<Contacts> getContactsByUserId(@PathVariable int userId);
	

}

