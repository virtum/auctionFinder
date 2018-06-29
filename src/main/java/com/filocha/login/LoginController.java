package com.filocha.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
public class LoginController {

    @Autowired
    private FacebookValidator facebookValidator;
    @Autowired
    private LoginService loginService;

    /**
     * Authenticates user using accessToken from facebook received with http request.
     *
     * @param token accessToken received from facebook after user login
     * @return response with information if user was properly authenticated on backend side or not
     */
    @CrossOrigin
    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public AuthenticateResponseModel authenticate(@RequestBody AuthenticateRequestModel token) {
        final String accessToken = token.getAccessToken();
        final String email = facebookValidator.getEmailFromFacebook(accessToken);

        boolean isLogged = loginService.authenticateUser(accessToken, email);

        return AuthenticateResponseModel
                .builder()
                .isLogged(isLogged)
                .build();
    }

    /**
     * Checks if user is authenticated or not.
     *
     * @param principal user data, contains information about user
     * @return response with information if user is authenticated or not
     */
    @CrossOrigin
    @RequestMapping(value = "/isLogged", method = RequestMethod.GET)
    public LoginCheckerResponseModel checkIfUserIsLogged(Principal principal) {
        boolean logged = loginService.checkIfUserIsLogged(principal);

        return LoginCheckerResponseModel
                .builder()
                .isLogged(logged)
                .build();
    }

}




