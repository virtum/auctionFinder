package com.filocha.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationHandler {

    /**
     * This method is used to add new user into spring security context to authenticate him.
     *
     * @param userModel contains data about user necessary to authentication
     * @return true if user was properly added to spring security context, otherwise false
     */
    public boolean authenticateUserAndInitializeSessionByUsername(UserAuthenticateModel userModel) {
        try {
            final Authentication auth = new UsernamePasswordAuthenticationToken(userModel, null, userModel.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(auth);

            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());

            return false;
        }
    }
}
