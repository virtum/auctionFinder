package com.filocha.logout;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class LogoutController {

    /**
     * This method is used to logout logged user.
     *
     * @param session is used to invalidate user from spring security context
     * @return response with flag to see if user was logged out
     */
    @CrossOrigin
    @RequestMapping(value = "/rest/logout", method = RequestMethod.GET)
    public LogoutResponseModel logout(HttpSession session) {
        session.invalidate();

        LogoutResponseModel response = new LogoutResponseModel();
        response.setResponse(false);
        return response;
    }
}
