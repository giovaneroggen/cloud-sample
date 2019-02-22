package br.com.roggen.security.contract.v1;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

public interface SecurityContractV1 {

    @PostMapping(path = "/uaa/oauth/token?grant_type=password",
                 produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
                 consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<Map> login(@RequestParam("username") String username,
                                     @RequestParam("password") String password);

}
