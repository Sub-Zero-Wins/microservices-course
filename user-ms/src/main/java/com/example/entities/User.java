package com.example.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor

public class User 
{
	

	@Id
	int userId;
	String userName;
	String userAddr;
	
	@Transient
	List<Contacts> contact;
	
	public User(int userId, String userName, String userAddr) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userAddr = userAddr;
	}

	public User()
	{
		
	}

}
