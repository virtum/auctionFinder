package com.filocha.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    /**
     * This method is used to authenticate user using accessToken from facebook received with http request.
     *
     * @param token accessToken received from facebook after user login
     * @return response with information if user was properly authenticated on backend side or not
     */
    @CrossOrigin
    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public AuthenticateResponseModel authenticate(@RequestBody AuthenticateRequestModel token) {
        String accessToken = token.getAccessToken();

        boolean logged = loginService.authenticateUser(accessToken);

        AuthenticateResponseModel response = new AuthenticateResponseModel();
        response.setLogged(logged);
        return response;
    }

    /**
     * This method is used to check if user is authenticated or not.
     *
     * @param principal user data, contains information about user
     * @return response with information if user is authenticated or not
     */
    @CrossOrigin
    @RequestMapping(value = "/isLogged", method = RequestMethod.GET)
    public LoginCheckerResponeModel checkIfUserIsLogged(Principal principal) {
        boolean logged = loginService.checkIfUserIsLogged(principal);

        LoginCheckerResponeModel response = new LoginCheckerResponeModel();
        response.setLogged(logged);
        return response;
    }


}




