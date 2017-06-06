package com.filocha.account;

import netscape.security.Principal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @CrossOrigin
    @RequestMapping(value = "/rest/subscriptions", method = RequestMethod.GET)
    public AccountResponseModel getAccountData(Principal principal) {
        AccountResponseModel response = new AccountResponseModel();
        response.setAccountData("test");

        return response;
    }
}
