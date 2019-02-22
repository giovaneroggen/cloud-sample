package br.com.roggen.security.client.v1;

import br.com.roggen.security.client.v1.config.FeignClientConfiguration;
import br.com.roggen.security.contract.v1.SecurityContractV1;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "http://SECURITY-SERVICE", configuration = FeignClientConfiguration.class)
public interface SecurityClientV1 extends SecurityContractV1 {
}
