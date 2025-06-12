package com.example.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Contacts 
{
	
	@Id
	int conId;
	String email;
	String phone;
	int userId;
	
	public Contacts(int conId, String email, String phone, int userId) {
		super();
		this.conId = conId;
		this.email = email;
		this.phone = phone;
		this.userId = userId;
	}

}
