package br.com.roggen.security.model;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

@Data
public class UserDetails extends User {

    public UserDetails(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    public UserDetails(String username, String password,
                       Collection<? extends GrantedAuthority> authorities, String customerId) {
        super(username, password, authorities);
    }
}
