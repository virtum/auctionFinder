package com.filocha.login;

import java.security.Principal;

public interface LoginService {

    /**
     * This method is used to add new user to spring security context, after that user will be authenticated.
     *
     * @param accessToken facebook accessToken, it will be used as a user password
     * @param email       user email, it will be used as a user name
     * @return true if user was properly authenticated, otherwise false
     */
    boolean authenticateUser(final String accessToken, final String email);

    /***
     * This method is used to check if user is authenticated or not.
     *
     * @param principal user data, contains information about user
     * @return true if user was properly authenticated, otherwise false
     */
    boolean checkIfUserIsLogged(Principal principal);
}
