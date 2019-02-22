package br.com.roggen.user.controller;

import br.com.roggen.user.contract.v1.UserContractV1;
import br.com.roggen.user.contract.v1.request.UserRequest;
import br.com.roggen.user.contract.v1.response.UserResponse;
import br.com.roggen.user.facade.UserFacadeV1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserControllerV1 implements UserContractV1 {

    @Autowired
    private UserFacadeV1 facade;

    @Override
    public UserResponse findByUsername(@RequestParam("username") String username) {
        return this.facade.findByUsername(username);
    }

    @Override
    public void save(@RequestBody UserRequest request) {
        this.facade.save(request);
    }
}
