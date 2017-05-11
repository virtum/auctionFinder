package com.filocha.login;

import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {

    @CrossOrigin
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public LoginResponseModel login(@RequestBody LoginRequestModel request) {

        LoginResponseModel response = new LoginResponseModel();
        response.setLogged(true);

        return response;
    }
}
