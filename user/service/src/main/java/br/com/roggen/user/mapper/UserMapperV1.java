package br.com.roggen.user.mapper;

import br.com.roggen.user.contract.v1.request.UserRequest;
import br.com.roggen.user.contract.v1.response.UserResponse;
import br.com.roggen.user.impl.data.User;

public class UserMapperV1 {

    public static UserResponse mapUserResponse(User user) {
        return UserResponse.builder()
                           .id(user.getId())
                           .username(user.getUsername())
                           .password(user.getPassword())
                           .roles(user.getRoles())
                           .firstname(user.getFirstname())
                           .lastname(user.getLastname())
                           .build();
    }

    public static User mapToUser(UserRequest request) {
        return User.builder()
                   .username(request.getUsername())
                   .password(request.getPassword())
                   .roles(request.getRoles())
                   .firstname(request.getFirstname())
                   .lastname(request.getLastname())
                   .build() ;
    }
}
