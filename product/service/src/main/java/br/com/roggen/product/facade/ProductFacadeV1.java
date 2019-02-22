package br.com.roggen.product.facade;

import br.com.roggen.product.contract.v1.request.ProductRequest;
import br.com.roggen.product.contract.v1.response.ProductResponse;
import br.com.roggen.product.impl.ProductService;
import br.com.roggen.product.mapper.ProductMapperV1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.List;

import static br.com.roggen.product.mapper.ProductMapperV1.*;

@Component
public class ProductFacadeV1 {

    @Autowired
    private ProductService service;

    public List<ProductResponse> findAll() {
        return mapProductResponse(this.service.findAll());
    }

    public ProductResponse save(ProductRequest request) {
        return mapProductResponse(this.service.save(mapFromRequest(request)));
    }

    public ProductResponse findOne(String id) {
        return this.service.findOne(id)
                .map(ProductMapperV1::mapProductResponse)
                .orElseThrow(() -> new RuntimeException(HttpStatus.NOT_FOUND.getReasonPhrase()));
    }

    public void delete(String id) {
        this.service.delete(id);
    }
}
