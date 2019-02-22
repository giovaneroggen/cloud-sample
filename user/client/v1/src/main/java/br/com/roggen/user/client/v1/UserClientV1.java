package br.com.roggen.user.client.v1;

import br.com.roggen.user.contract.v1.UserContractV1;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "http://USER-SERVICE")
public interface UserClientV1 extends UserContractV1 {
}
