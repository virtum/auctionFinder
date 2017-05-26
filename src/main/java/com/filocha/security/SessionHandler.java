package com.filocha.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class SessionHandler {

    public boolean authenticateUserAndInitializeSessionByUsername(UserAuthenticateModel userModel) {
        boolean result = true;

        try {
            // generate session if one doesn't exist
            //request.getSession();

            // Authenticate the user
            Authentication auth = new UsernamePasswordAuthenticationToken(userModel, null, userModel.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(auth);

        } catch (Exception e) {
            System.out.println(e.getMessage());

            result = false;
        }

        return result;
    }
}
