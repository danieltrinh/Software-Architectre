package shop.domain.product;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Stock {
	private int quality;
	private String locationCode;
	
	public Stock() {
	
	}
	

	public Stock(int quality, String locationCode) {
		super();
		this.quality = quality;
		this.locationCode = locationCode;
	}
	public int getQuality() {
		return quality;
	}
	public void setQuality(int quality) {
		this.quality = quality;
	}
	public String getLocationCode() {
		return locationCode;
	}
	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}
	
	
}
