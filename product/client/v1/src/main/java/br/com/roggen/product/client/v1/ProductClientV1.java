package br.com.roggen.product.client.v1;

import br.com.roggen.product.contract.v1.ProductContractV1;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "http://PRODUCT-SERVICE")
public interface ProductClientV1 extends ProductContractV1 {
}
