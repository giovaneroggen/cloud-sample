package br.com.roggen.user.impl.data.repository;

import br.com.roggen.user.impl.data.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {

    public Optional<User> findFirstByUsername(String username);
}
