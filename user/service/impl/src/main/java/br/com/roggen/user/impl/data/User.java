package br.com.roggen.user.impl.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class User {

    @Id
    private String id;
    private String username;
    private String password;
    private List<String> roles;
    private String firstname;
    private String lastname;
}
