package br.com.roggen.product.mapper;

import br.com.roggen.product.contract.v1.request.ProductRequest;
import br.com.roggen.product.contract.v1.response.ProductResponse;
import br.com.roggen.product.impl.data.Product;

import java.util.List;
import java.util.stream.Collectors;

public class ProductMapperV1 {

    public static List<ProductResponse> mapProductResponse(List<Product> list) {
        return list.stream()
                .map(ProductMapperV1::mapProductResponse)
                .collect(Collectors.toList());
    }

    public static ProductResponse mapProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .build();
    }

    public static Product mapFromRequest(ProductRequest request) {
        return Product.builder()
                .name(request.getName())
                .price(request.getPrice())
                .build();
    }
}
