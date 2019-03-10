package shop.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.domain.order.Order;
import shop.domain.order.OrderFactory;
import shop.domain.shoppingcart.ShoppingCart;
import shop.repository.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	OrderRepository orderRepository;
	
	public void createOrder(ShoppingCart shoppingCart) {
		// transform shopping cart to order
		Order newOrder = OrderFactory.createOrder(shoppingCart);
		// save to database
		orderRepository.save(newOrder);
	}
	
	public Order getOrder(String orderId) {
		Optional<Order> order = orderRepository.findById(orderId);
		
		if(order.isPresent())
			return order.get();
		return null;
	}

}
