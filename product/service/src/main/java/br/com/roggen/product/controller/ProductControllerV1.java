package br.com.roggen.product.controller;

import br.com.roggen.product.contract.v1.ProductContractV1;
import br.com.roggen.product.contract.v1.request.ProductRequest;
import br.com.roggen.product.contract.v1.response.ProductResponse;
import br.com.roggen.product.facade.ProductFacadeV1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductControllerV1 implements ProductContractV1 {

    @Autowired
    private ProductFacadeV1 facade;

    @Override
    public List<ProductResponse> findAll() {
        return this.facade.findAll();
    }

    @Override
    public ProductResponse save(ProductRequest request) {
        return this.facade.save(request);
    }

    @Override
    public ProductResponse findOne(String id) {
        return this.facade.findOne(id);
    }

    @Override
    public void delete(String id) {
        this.facade.delete(id);
    }
}
