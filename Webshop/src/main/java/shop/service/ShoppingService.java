package shop.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.domain.Product;
import shop.domain.ShoppingCart;
import shop.repository.ShoppingCartRepository;

@Service
public class ShoppingService {
	
	@Autowired
	ShoppingCartRepository shoppingCartRepository;
	
	@Autowired
	ProductCatalogService productService;
	
	public void addToCart(String cartId, String productNumber, int quantity) {
		Optional<ShoppingCart> shoppingCart = shoppingCartRepository.findById(cartId);
		Product product = productService.getProduct(productNumber);
		if(shoppingCart.isPresent() && product != null) {
			ShoppingCart cart = shoppingCart.get();
			cart.addToCart(product, quantity);
			shoppingCartRepository.save(cart);
		}
		else if(product != null) {
			ShoppingCart cart = new ShoppingCart(cartId);
			cart.addToCart(product, quantity);
			shoppingCartRepository.save(cart);
		}
		
	}
	
	public ShoppingCart getCart(String cartId) {
		Optional<ShoppingCart> shoppingCart = shoppingCartRepository.findById(cartId);
		if(shoppingCart.isPresent())
			return shoppingCart.get();
		return null;
	}
}
