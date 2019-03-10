package shop.domain.shoppingcart;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

public class Product {
	private String productNumber;
	private double price;
	private String description;
	
	public Product(String productNumber, double price, String description) {
		super();
		this.productNumber = productNumber;
		this.price = price;
		this.description = description;
	}
	public String getProductNumber() {
		return productNumber;
	}
	public void setProductNumber(String productNumber) {
		this.productNumber = productNumber;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
