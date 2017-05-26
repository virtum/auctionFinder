package com.filocha.logout;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class LogoutController {

    @CrossOrigin
    @RequestMapping(value = "/rest/logout", method = RequestMethod.GET)
    public LogoutResponseModel logout(HttpSession session) {
        session.invalidate();

        LogoutResponseModel response = new LogoutResponseModel();
        response.setResponse(false);
        return response;
    }
}
