package br.com.roggen.security;

import br.com.roggen.security.model.UserDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;

public class SecurityContextHelper {

    public static UserDetails getPrincipal() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication instanceof OAuth2Authentication){
            OAuth2Authentication oAuth2authentication = (OAuth2Authentication) authentication;
            Authentication userAuthentication = oAuth2authentication.getUserAuthentication();
            final Object principal = userAuthentication.getPrincipal();
            if(principal.getClass().isAssignableFrom(UserDetails.class)){
                return (UserDetails) principal;
            }
        }
        return null;
    }


}
