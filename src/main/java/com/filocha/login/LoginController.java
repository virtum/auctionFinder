package com.filocha.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.security.Principal;

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @CrossOrigin
    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public AuthenticateResponseModel authenticate(@RequestBody AuthenticateRequestModel token) {
        String accessToken = token.getAccessToken();

        boolean logged = loginService.handleLogin(accessToken);

        AuthenticateResponseModel response = new AuthenticateResponseModel();
        response.setLogged(logged);
        return response;
    }

    @CrossOrigin
    @RequestMapping(value = "/isLogged", method = RequestMethod.GET)
    public LoginCheckerResponeModel checkIfUserIsLogged(Principal principal, HttpSession session) {
        Authentication authentication = (Authentication) principal;
        LoginCheckerResponeModel response = new LoginCheckerResponeModel();

        if (authentication == null) {
            response.setLogged(false);
            return response;
        }
        response.setLogged(authentication.isAuthenticated());
        return response;
    }


}




