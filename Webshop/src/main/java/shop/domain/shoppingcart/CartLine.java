package shop.domain.shoppingcart;

import org.springframework.data.mongodb.core.mapping.Document;

import shop.domain.product.Product;

@Document
public class CartLine {
	
	private Product product;
	private int quantity;
	
	public CartLine(Product product, int quantity) {
		super();
		this.product = product;
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
