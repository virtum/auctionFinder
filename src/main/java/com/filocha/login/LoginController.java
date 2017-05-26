package com.filocha.login;

import com.filocha.security.SessionHandler;
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
        System.out.println(principal);
        System.out.println(request.getSession().getId());
        String accessToken = token.getAccessToken();

        boolean logged = false;
        try {
            String email = getEmailFromFacebook(accessToken);
            UserModel user = new UserModel();
            user.setPassword("");
            user.setUserName("");

            logged = sessionHandler.authenticateUserAndInitializeSessionByUsername(user);

        } catch (Exception exc) {
            //TODO Change exception to more descriptive type
            //print exc
        }

        AuthenticateResponseModel response = new AuthenticateResponseModel();
        response.setLogged(logged);
        return response;
    }

    @CrossOrigin
    @RequestMapping(value = "/isLogged", method = RequestMethod.GET)
    public LoginCheckerResponeModel checkIfUserIsLogged(Principal principal, HttpSession session) {
        System.out.println("in auth");
        System.out.println(session.getId());

        Authentication authentication = (Authentication) principal;
        LoginCheckerResponeModel response = new LoginCheckerResponeModel();

        if (authentication == null) {
            response.setLogged(false);
            return response;
        }
        response.setLogged(authentication.isAuthenticated());
        return response;
    }

    @CrossOrigin
    @RequestMapping(value = "/rest/logout", method = RequestMethod.GET)
    public LogoutResponseModel logout(HttpSession session) {
        System.out.println(session.getId());
        System.out.println("in logout");

        session.invalidate();
        //TODO add something to check id session was invalidate before response

        LogoutResponseModel response = new LogoutResponseModel();
        response.setResponse(false);
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




