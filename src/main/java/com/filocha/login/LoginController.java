package com.filocha.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @CrossOrigin
    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public AuthenticateResponseModel authenticate(@RequestBody AuthenticateRequestModel token) {
        String accessToken = token.getAccessToken();

        boolean logged = loginService.authenticateUser(accessToken);

        AuthenticateResponseModel response = new AuthenticateResponseModel();
        response.setLogged(logged);
        return response;
    }

    @CrossOrigin
    @RequestMapping(value = "/isLogged", method = RequestMethod.GET)
    public LoginCheckerResponeModel checkIfUserIsLogged(Principal principal) {
        boolean logged = loginService.checkIfUserIsLogged(principal);

        LoginCheckerResponeModel response = new LoginCheckerResponeModel();
        response.setLogged(logged);
        return response;
    }


}




