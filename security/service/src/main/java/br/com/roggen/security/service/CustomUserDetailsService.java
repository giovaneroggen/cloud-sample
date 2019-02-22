package br.com.roggen.security.service;

import br.com.roggen.security.model.UserDetails;
import br.com.roggen.user.client.v1.UserClientV1;
import br.com.roggen.user.contract.v1.request.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.common.exceptions.BadClientCredentialsException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserClientV1 clientV1;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return Optional.ofNullable(
            this.clientV1.findByUsername(username)
        ).map(it ->
            new UserDetails(it.getUsername(),
                           it.getPassword(),
                           it.getRoles()
                             .stream()
                             .map(SimpleGrantedAuthority::new)
                             .collect(Collectors.toList())))
         .orElseThrow(BadClientCredentialsException::new);
    }

    public void save(String username, String password, String... roles){
        this.clientV1.save(UserRequest.builder()
                                      .username(username)
                                      .password(this.passwordEncoder.encode(password))
                                      .roles(Arrays.asList(roles))
                                      .firstname("FIRST "+ username)
                                      .lastname("LAST "+ username)
                                      .build());
    }
}
