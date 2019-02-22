package br.com.roggen.user.facade;

import br.com.roggen.spring.web.config.exception.GenericException;
import br.com.roggen.user.contract.v1.request.UserRequest;
import br.com.roggen.user.contract.v1.response.UserResponse;
import br.com.roggen.user.impl.UserService;
import br.com.roggen.user.mapper.UserMapperV1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class UserFacadeV1 {

    @Autowired
    private UserService service;

    public UserResponse findByUsername(String username) {
        return this.service
                   .findFirstByUsername(username)
                   .map(UserMapperV1::mapUserResponse)
                   .orElseThrow(() -> new GenericException(HttpStatus.NOT_FOUND));
    }

    public void save(UserRequest request) {
        this.service.save(UserMapperV1.mapToUser(request));
    }
}
