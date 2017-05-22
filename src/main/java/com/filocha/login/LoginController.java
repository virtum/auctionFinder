package com.filocha.login;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.json.JSONObject;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.Principal;

@RestController
public class LoginController {

    @CrossOrigin
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public LoginResponseModel login(@RequestBody LoginRequestModel request) {

        LoginResponseModel response = new LoginResponseModel();
        response.setLogged(true);

        return response;
    }

    @CrossOrigin
    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public AccessTokenResponse authenticate(@RequestBody AccessTokenRequest token, HttpServletRequest request) throws Exception {
        System.out.println(request.getSession().getId());
        String accessToken = token.getAccessToken();
        String email = getEmailFromFacebook(accessToken);

        // System.out.println("token: " + accessToken + "\nemail: " + email);

        //TODO Do i really need to store password?
        //TODO accessToken expiration time
        UserModel user = new UserModel();
        user.setPassword(accessToken);
        user.setUserName(email);

        boolean logged = authenticateUserAndInitializeSessionByUsername(user, request);

        AccessTokenResponse response = new AccessTokenResponse();
        response.setResponse(logged);
        return response;
    }

    @CrossOrigin
    @RequestMapping(value = "/auth", method = RequestMethod.GET)
    public AccessTokenResponse auth(Principal principal, HttpSession session) {
        System.out.println("in auth");
        System.out.println(session.getId());

        Authentication authentication = (Authentication) principal;
        AccessTokenResponse response = new AccessTokenResponse();

        if (authentication == null) {
            response.setResponse(false);
            return response;
        }
        response.setResponse(authentication.isAuthenticated());
        return response;
    }

    @CrossOrigin
    @RequestMapping(value = "/rest/logout", method = RequestMethod.GET)
    public AccessTokenResponse logout(HttpSession session) {
        System.out.println(session.getId());
        System.out.println("in logout");

        session.invalidate();
        //TODO add something to check id session was invalidate before response

        AccessTokenResponse response = new AccessTokenResponse();
        response.setResponse(false);
        return response;
    }

    public boolean authenticateUserAndInitializeSessionByUsername(UserModel userDetailsManager, HttpServletRequest request) {
        boolean result = true;

        try {
            // generate session if one doesn't exist
            request.getSession();

            // Authenticate the user
            UserDetails user = userDetailsManager;
            Authentication auth = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(auth);

            //Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            //System.out.println(authentication);
        } catch (Exception e) {
            System.out.println(e.getMessage());

            result = false;
        }

        return result;
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

class AccessTokenRequest {
    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    private String accessToken;

}

class AccessTokenResponse {
    public boolean getResponse() {
        return response;
    }

    public void setResponse(boolean response) {
        this.response = response;
    }

    private boolean response;

}


