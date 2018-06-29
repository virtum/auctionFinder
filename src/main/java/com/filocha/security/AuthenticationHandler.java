package com.filocha.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationHandler {

    /**
     * Adds new user into spring security context to authenticate him.
     *
     * @param userModel contains data about user necessary to authentication
     * @return true if user was authenticated, otherwise false
     */
    public boolean authenticateUserAndInitializeSessionByUsername(UserAuthenticateModel userModel) {
        final Authentication auth = new UsernamePasswordAuthenticationToken(userModel, null, userModel.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(auth);

        return auth.isAuthenticated();
    }
}
