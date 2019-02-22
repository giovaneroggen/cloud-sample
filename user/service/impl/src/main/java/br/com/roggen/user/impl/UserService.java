package br.com.roggen.user.impl;

import br.com.roggen.user.impl.data.User;
import br.com.roggen.user.impl.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public Optional<User> findFirstByUsername(String username){
        return this.repository.findFirstByUsername(username);
    }

    public void save(User user) {
        this.repository.save(user);
    }
}
