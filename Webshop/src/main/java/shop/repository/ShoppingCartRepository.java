package shop.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import shop.domain.shoppingcart.ShoppingCart;

public interface ShoppingCartRepository extends MongoRepository <ShoppingCart, String>{
	 
}
