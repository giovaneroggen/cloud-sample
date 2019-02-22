package br.com.roggen.product.client.v2;

import br.com.roggen.product.contract.v2.ProductContractV2;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "http://PRODUCT-SERVICE")
public interface ProductClientV2 extends ProductContractV2 {
}
