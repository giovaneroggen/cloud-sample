package br.com.roggen.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.oauth2.provider.token.AuthenticationKeyGenerator;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

@Configuration
public class RedisConfiguration {
    @Autowired
    private RedisConnectionFactory redisConnectionFactory;

    @Autowired
    AuthenticationKeyGenerator authenticationKeyGenerator;

    @Bean
    TokenStore tokenStore(){
        final RedisTokenStore redisTokenStore = new RedisTokenStore(this.redisConnectionFactory);
        redisTokenStore.setAuthenticationKeyGenerator(authenticationKeyGenerator);
        return redisTokenStore;
    }
}

