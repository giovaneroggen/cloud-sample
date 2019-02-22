package br.com.roggen.product.impl.data.repository;

import br.com.roggen.product.impl.data.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}
