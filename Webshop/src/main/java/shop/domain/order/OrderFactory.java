package shop.domain.order;

import java.util.Date;

import shop.domain.shoppingcart.CartLine;
import shop.domain.shoppingcart.ShoppingCart;

public class OrderFactory {
	
	public static Order createOrder(ShoppingCart cart) {
		Order newOrder = new Order(cart.getCartId(), new Date(), "placed");
		
		for(CartLine line : cart.getCartLines()) {
			// new order product
			Product product = new Product(line.getProduct().getProductNumber(), line.getProduct().getPrice(), line.getProduct().getDescription());
			
			newOrder.addOrderLine(new OrderLine(product, line.getQuantity()));
		}		
		return newOrder;
		
	}

}
