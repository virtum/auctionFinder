package com.filocha.account;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @CrossOrigin
    @RequestMapping(value = "/rest/account", method = RequestMethod.GET)
    public AccountResponseModel getAccountData() {
        AccountResponseModel response = new AccountResponseModel();
        response.setAccountData("test");

        return response;
    }
}
