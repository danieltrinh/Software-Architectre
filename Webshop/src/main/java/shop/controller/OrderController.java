package shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import shop.domain.order.Order;
import shop.service.OrderService;

@RestController
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@GetMapping("order/{orderId}")
	public ResponseEntity<?> getOrder(@PathVariable String orderId){
		return new ResponseEntity<Order> (orderService.getOrder(orderId), HttpStatus.OK);
	}	
}
