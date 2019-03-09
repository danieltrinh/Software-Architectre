package shop.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.domain.Product;
import shop.domain.Stock;
import shop.repository.ProductRepository;

@Service
public class ProductCatalogService {
	
	@Autowired
	ProductRepository productRepository;
	
	public void addProduct(String productNumber, double price, String description) {
		Product prod = new Product(productNumber, price, description);
		productRepository.save(prod);
	}
	
	public Product getProduct(String productNumber) {
		Optional<Product> product = productRepository.findById(productNumber); 
		if(product.isPresent())
			return product.get();
		return null;
	}
	
	public void setStock(String productNumber, int quantity, String locationcode) {
		Optional<Product> product = productRepository.findById(productNumber);
		if(product.isPresent()) {
			Product prod = product.get(); 
			prod.setStock(new Stock(quantity, locationcode));
			productRepository.save(prod);
		}
	}
}
