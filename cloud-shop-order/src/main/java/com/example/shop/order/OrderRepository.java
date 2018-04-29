
package com.example.shop.order;



import org.springframework.data.jpa.repository.Query;

//import java.util.List;

//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
//import org.springframework.samples.petclinic.model.PetType;
//import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Transactional;

import com.example.shop.model.Order;

//This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
//CRUD refers Create, Read, Update, Delete

public interface OrderRepository extends CrudRepository<Order, Long> {
	
/*	@Query("SELECT name FROM Product  ORDER BY name")
	@Transactional(readOnly = true)
List<Product> getAllProducts();									*/
	@Query(value="SELECT order_Id FROM orders ORDER BY order_Id DESC LIMIT 1",nativeQuery=true)
	@Transactional(readOnly = true)
	//Order getLastOrder();
	int getLastOrder();
	

}