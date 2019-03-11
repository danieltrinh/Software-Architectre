package shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import shop.domain.order.Order;

@SpringBootApplication
public class WebShopApplication implements CommandLineRunner{
	
	@Autowired
	private RestOperations restTemplate;

	public static void main(String[] args) {
		SpringApplication.run(WebShopApplication.class, args);
	}
	
	@Bean
	RestTemplate restTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
		return restTemplate;
	}

	@Override
	public void run(String... args) throws Exception {
		String baseUrl = "http://localhost:8080/";
		
		//add products
		restTemplate.postForLocation(baseUrl + "product/add/1/100/product1", null);
		restTemplate.postForLocation(baseUrl + "product/add/2/200/product2", null);
		
		//add to cart
		restTemplate.postForLocation(baseUrl + "cart/1/1/3", null);
		restTemplate.postForLocation(baseUrl + "cart/1/2/2", null);
		
		//checkout
		restTemplate.postForLocation(baseUrl + "cart/checkout/1", null);
		
		//get order
		Order order = restTemplate.getForObject(baseUrl + "order/1", Order.class);	
		order.print();
		
	}
}
