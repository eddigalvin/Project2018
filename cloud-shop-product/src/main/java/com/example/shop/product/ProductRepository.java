package com.example.shop.product;

//import java.util.List;

//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
//import org.springframework.samples.petclinic.model.PetType;
//import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.shop.model.Product;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
@CrossOrigin(origins = "http://localhost:4200")
public interface ProductRepository extends CrudRepository<Product, Integer> {
	
/*	@Query("SELECT name FROM Product  ORDER BY name")
	@Transactional(readOnly = true)
    List<Product> getAllProducts();			*/

}
