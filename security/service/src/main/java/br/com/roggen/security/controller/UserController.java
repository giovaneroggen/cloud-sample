package br.com.roggen.security.controller;

import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/users/current")
public class UserController {

    @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Principal principal(@AuthenticationPrincipal Principal principal){
        return principal;
    }

    @PreAuthorize("hasAuthority('APP')")
    @GetMapping(path = "/authority", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Principal authority(@AuthenticationPrincipal Principal principal){
        return principal;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping(path = "/role", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Principal role(@AuthenticationPrincipal Principal principal){
        return principal;
    }
}
