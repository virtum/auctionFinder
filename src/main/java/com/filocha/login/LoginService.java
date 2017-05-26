package com.filocha.login;

import java.security.Principal;

public interface LoginService {

    /**
     * This method is used to add new user to spring security context, after that user will be authenticated.
     *
     * @param accessToken facebook accessToken is used to get more information about user
     * @return true if user was properly authenticated, otherwise false
     */
    boolean authenticateUser(String accessToken);

    boolean checkIfUserIsLogged(Principal principal);
}
