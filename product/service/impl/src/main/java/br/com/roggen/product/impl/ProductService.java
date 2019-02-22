package br.com.roggen.product.impl;

import br.com.roggen.product.impl.data.Product;
import br.com.roggen.product.impl.data.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.DoubleStream;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<Product> findAll() {
        return repository.findAll();
    }

    public Product save(Product entity) {
        return this.repository.save(entity);
    }

    public Optional<Product> findOne(String id) {
        return this.repository.findById(id);
    }

    public void delete(String id) {
        this.repository.deleteById(id);
    }
}
