package com.example.shop.customer;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

//import java.util.List;

//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
//import org.springframework.samples.petclinic.model.PetType;
//import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Transactional;

import com.example.shop.model.Customer;

//This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
//CRUD refers Create, Read, Update, Delete

public interface CustomerRepository extends CrudRepository<Customer, Long> {
	/*
	@Query("SELECT cust_id FROM customer  WHERE customer.email="email" AND customer.password = "password")
	@Transactional(readOnly = true)
  Integer login(email,password);	
  		
  @Query("select c from User u where u.firstname = :#{#customer.firstname}")
  List<User> findUsersByCustomersFirstname(@Param("customer") Customer customer);		*/ 
	
	 @Query
	  Customer findByEmail(String email);

	

}
