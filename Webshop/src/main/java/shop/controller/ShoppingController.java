package shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import shop.domain.ShoppingCart;
import shop.service.ShoppingService;

@RestController
public class ShoppingController {
	
	@Autowired
	ShoppingService shoppingService;
	
	@PostMapping(value = "/cart/{cartId}/{productnumber}/{quantity}")
	public ResponseEntity<String> addToCart(@PathVariable String cartId, @PathVariable String productnumber, @PathVariable int quantity) {
		shoppingService.addToCart(cartId, productnumber, quantity);
		return new ResponseEntity<String>("Added to Cart" , HttpStatus.OK);		
	}
	
	@GetMapping("/cart/{cartId}")
	public ResponseEntity<?> getCart(@PathVariable String cartId) {
		ShoppingCart cart = shoppingService.getCart(cartId);
		cart.print();
		return new ResponseEntity<ShoppingCart>(cart, HttpStatus.OK);
	}
}
