package br.com.roggen.product.contract.v1;

import br.com.roggen.product.contract.v1.request.ProductRequest;
import br.com.roggen.product.contract.v1.response.ProductResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface ProductContractV1 {

    @GetMapping("/products/v1")
    public List<ProductResponse> findAll();

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/products/v1")
    public ProductResponse save(@RequestBody ProductRequest request);

    @GetMapping("/products/v1/{id}")
    public ProductResponse findOne(@PathVariable("id") String id);

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/products/v1/{id}")
    public void delete(@PathVariable("id") String id);
}
