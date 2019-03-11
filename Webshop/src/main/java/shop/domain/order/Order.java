package shop.domain.order;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Order {
	
	@Id
	private String orderId;
	private Date date;
	private String status;
	

	private List<OrderLine> orderLines = new ArrayList<>();

	public Order() {
		
	}

	public Order(String orderId, Date date, String status) {
		super();
		this.orderId = orderId;
		this.date = date;
		this.status = status;
	}
	
	public void print() {
		System.out.println("Content of the order:");
		System.out.println("Ordernr :"+orderId+" , Date : "+date+" , Status : "+status);
		for (OrderLine oline : orderLines) {
			System.out.println(oline.getQuantity() + " " + oline.getProduct().getProductNumber() + " "
					+ oline.getProduct().getDescription() + " " + oline.getProduct().getPrice());
		}
		System.out.println("Total price =" + getTotalPrice());
	}

	private double getTotalPrice() {
		double totalPrice = 0.0;
		for (OrderLine oline : orderLines) {
			totalPrice=totalPrice+(oline.getProduct().getPrice() * oline.getQuantity());
		}
		return totalPrice;
	}
	
	public String getOrderId() {
		return orderId;
	}
	
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<OrderLine> getOrderLines() {
		return orderLines;
	}

	public void setOrderLines(List<OrderLine> orderLines) {
		this.orderLines = orderLines;
	}
	
	public void addOrderLine(OrderLine orderLine) {
		this.orderLines.add(orderLine);
	}
	
}
