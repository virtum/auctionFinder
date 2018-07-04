package com.filocha.login;

import com.filocha.security.AuthenticationHandler;
import com.filocha.security.UserAuthenticateModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.security.Principal;
import java.util.Objects;

@Service
public class LoginService {

    @Autowired
    private AuthenticationHandler authenticationHandler;
    @Autowired
    private FacebookValidator facebookValidator;

    /**
     * Adds new user to spring security context, after that user will be authenticated.
     *
     * @param accessToken facebook accessToken, it will be used as a user password
     * @param email       user email, it will be used as a user name
     * @return true if user was properly authenticated, otherwise false
     */
    public boolean authenticateUser(final String accessToken, final String email) {
        return !StringUtils.isEmpty(email) &&
                authenticationHandler.authenticateUserAndInitializeSessionByUsername(UserAuthenticateModel
                        .builder()
                        .password(accessToken)
                        .userName(email)
                        .build());
    }

    /**
     * Checks if user is authenticated or not.
     *
     * @param principal user data, contains information about user
     * @return true if user was properly authenticated, otherwise false
     */
    public boolean checkIfUserIsLogged(Principal principal) {
        final Authentication authentication = (Authentication) principal;

        return Objects.nonNull(authentication) && authentication.isAuthenticated();
    }
}
