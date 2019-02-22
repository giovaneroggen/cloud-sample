package br.com.roggen.gateway.controller;

import br.com.roggen.gateway.request.LoginRequest;
import br.com.roggen.security.SecurityContextHelper;
import br.com.roggen.security.client.v1.SecurityClientV1;
import br.com.roggen.security.model.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Map;

@RestController
@RequestMapping("/gateway")
public class LoginController {

    @Autowired
    private SecurityClientV1 securityClientV1;

    @PostMapping(path = "/login", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
                 produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Map> login(@RequestBody LoginRequest request){
        return securityClientV1.login(request.getUsername(), request.getPassword());
    }

    @PreAuthorize("hasAuthority('admin')")
    @GetMapping(path = "/principal", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Principal principal(@AuthenticationPrincipal Principal principal){
        return principal;
    }

    @GetMapping(path = "/userdetails", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public UserDetails principal(){
        return SecurityContextHelper.getPrincipal();
    }
}
