package shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import shop.domain.Product;
import shop.service.ProductCatalogService;

@RestController
public class ProductController {
	
	@Autowired
	ProductCatalogService productCatalogService;
	
	@GetMapping("/product/{productNumber}")
	public ResponseEntity<?> getProduct(@PathVariable String productNumber) {
		return new ResponseEntity<Product> (productCatalogService.getProduct(productNumber), HttpStatus.OK);  
	}
	
	@PostMapping("/product/add/{productNumber}/{price}/{description}")
	public ResponseEntity<?> addProduct(@PathVariable String productNumber, @PathVariable double price, @PathVariable String description) {
		productCatalogService.addProduct(productNumber, price, description);
		String msg = "Product added successfully";
		return new ResponseEntity<String> (msg, HttpStatus.OK); 
	}
	
	@PostMapping(value = "/product/stock/{productnumber}/{quantity}/{locationcode}")
	public ResponseEntity<?> setStock(@PathVariable String productnumber, @PathVariable int quantity, @PathVariable String locationcode){
		productCatalogService.setStock(productnumber, quantity, locationcode);
		return new ResponseEntity<String>("stock set", HttpStatus.OK);
	}
	
	@GetMapping("/home")
	public ResponseEntity<?> getHome() {
		String msg = "Hello User";
		return new ResponseEntity<String> (msg, HttpStatus.OK);
	}
}
