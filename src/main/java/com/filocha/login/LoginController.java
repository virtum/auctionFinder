package com.filocha.login;

import com.filocha.security.SessionHandler;
import com.filocha.security.UserAuthenticateModel;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.Principal;

@RestController
public class LoginController {

    @Autowired
    private SessionHandler sessionHandler;

    @CrossOrigin
    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public AuthenticateResponseModel authenticate(@RequestBody AuthenticateRequestModel token, HttpServletRequest request, Principal principal) {
        String accessToken = token.getAccessToken();

        boolean logged = false;
        try {
            String email = getEmailFromFacebook(accessToken);

            UserAuthenticateModel user = new UserAuthenticateModel();
            user.setPassword(accessToken);
            user.setUserName(email);

            logged = sessionHandler.authenticateUserAndInitializeSessionByUsername(user);

        } catch (Exception exc) {
            //TODO Change exception to more descriptive type
        }

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

    private String getEmailFromFacebook(String accessToken) throws Exception {
        String url = "https://graph.facebook.com/me?fields=email&access_token=" + accessToken;

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        //add request header
        con.setRequestProperty("User-Agent", "Mozilla/5.0");

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //print result
        JSONObject json = new JSONObject(response.toString());

        return json.getString("email");
    }
}




