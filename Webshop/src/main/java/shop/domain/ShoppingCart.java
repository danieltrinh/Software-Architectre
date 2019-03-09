package shop.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class ShoppingCart {
	
	@Id
	private String cartId;
	private List<CartLine> cartLines = new ArrayList<>();
	
	public ShoppingCart(String cartId) {
		super();
		this.cartId = cartId;
	}

	public void addToCart(Product product, int quantity) {
		for(CartLine line : cartLines) {
			if(line.getProduct().equals(product)) {
				line.setQuantity(line.getQuantity() + quantity);
				return;
			}
		}
		cartLines.add(new CartLine(product, quantity));
	}

	public void print() {
		System.out.println("Content of the shoppingcart:");
		for (CartLine cline : cartLines) {
			System.out.println(cline.getQuantity() + " "
					+ cline.getProduct().getProductNumber() + " "
					+ cline.getProduct().getDescription() + " "
					+ cline.getProduct().getPrice());
		}
		System.out.println("Total price ="+getTotalPrice());
	}
	
	public double getTotalPrice(){
		double totalPrice = 0.0;
		for (CartLine cline : cartLines) {
			totalPrice=totalPrice+(cline.getProduct().getPrice() * cline.getQuantity());
		}
		return totalPrice;
	}
	
	public void removeFromCart(Product product){
		Iterator<CartLine> iter = cartLines.iterator();
		while (iter.hasNext()){
			CartLine cline = iter.next();
			if (cline.getProduct().getProductNumber().equals(product.getProductNumber())){
				if (cline.getQuantity()>1){
					cline.setQuantity(cline.getQuantity()-1);
				}
				else{
					iter.remove();
				}
			}
		}
	}

	public String getCartId() {
		return cartId;
	}

	public void setCartId(String cartId) {
		this.cartId = cartId;
	}

	public List<CartLine> getCartLines() {
		return cartLines;
	}

	public void setCartLines(List<CartLine> cartLines) {
		this.cartLines = cartLines;
	}
	
	
}
