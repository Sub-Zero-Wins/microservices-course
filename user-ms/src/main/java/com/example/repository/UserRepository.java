package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entities.User;


public interface UserRepository extends JpaRepository<User,Integer> {

}
