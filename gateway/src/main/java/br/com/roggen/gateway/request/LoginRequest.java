package br.com.roggen.gateway.request;

import lombok.Data;

@Data
public class LoginRequest {
    private String username;
    private String password;
}
