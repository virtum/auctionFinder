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
public class LoginServiceImpl implements LoginService {

    @Autowired
    private AuthenticationHandler authenticationHandler;
    @Autowired
    private FacebookValidator facebookValidator;

    @Override
    public boolean authenticateUser(final String accessToken, final String email) {
        return !StringUtils.isEmpty(email) &&
                authenticationHandler.authenticateUserAndInitializeSessionByUsername(UserAuthenticateModel
                        .builder()
                        .password(accessToken)
                        .userName(email)
                        .build());
    }

    @Override
    public boolean checkIfUserIsLogged(Principal principal) {
        final Authentication authentication = (Authentication) principal;

        return Objects.nonNull(authentication) && authentication.isAuthenticated();
    }
}
