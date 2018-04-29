package com.example.shop.orderline;

//import java.util.List;

//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
//import org.springframework.samples.petclinic.model.PetType;
//import org.springframework.transaction.annotation.Transactional;

import com.example.shop.model.OrderLine;
import com.example.shop.model.Product;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface OrderlineRepository extends CrudRepository<OrderLine, Integer> {
	
/*	@Query("SELECT name FROM Product  ORDER BY name")
	@Transactional(readOnly = true)
    List<Product> getAllProducts();			*/

}
