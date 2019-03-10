package shop.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import shop.domain.product.Product;

public interface ProductRepository extends MongoRepository<Product, String>{

}
