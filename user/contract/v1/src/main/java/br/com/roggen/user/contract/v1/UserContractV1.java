package br.com.roggen.user.contract.v1;

import br.com.roggen.user.contract.v1.request.UserRequest;
import br.com.roggen.user.contract.v1.response.UserResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public interface UserContractV1 {

    @GetMapping(path = "/users/v1/search/findByUsername",
                produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public UserResponse findByUsername(@RequestParam("username") String username);


    @PostMapping(path = "/users/v1",
                 consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
                 produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void save(@RequestBody UserRequest request);
}
