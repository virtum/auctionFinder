package com.filocha.login;

import com.filocha.security.AuthenticationHandler;
import com.filocha.security.UserAuthenticateModel;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.Principal;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private AuthenticationHandler authenticationHandler;

    @Override
    public boolean authenticateUser(final String accessToken) {
        final String email = getEmailFromFacebook(accessToken);

        // final AuthenticateResponseModel response = new AuthenticateResponseModel();
        if (email.equals("")) {
            return false;
        }

        return authenticationHandler.authenticateUserAndInitializeSessionByUsername(UserAuthenticateModel.builder()
                .password(accessToken)
                .userName(email)
                .build());
    }

    @Override
    public boolean checkIfUserIsLogged(Principal principal) {
        Authentication authentication = (Authentication) principal;

        if (authentication == null) {
            return false;
        }
        return authentication.isAuthenticated();
    }

    /***
     * This method is used to send request via http to facebook to get user e-mail using accessToken.
     *
     * @param accessToken token received after login to facebook
     * @return user e-mail, in case of exception empty string
     */
    private String getEmailFromFacebook(String accessToken) {
        String url = "https://graph.facebook.com/me?fields=email&access_token=" + accessToken;

        try {
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            // optional default is GET
            con.setRequestMethod("GET");

            //add request header
            con.setRequestProperty("User-Agent", "Mozilla/5.0");

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            JSONObject json = new JSONObject(response.toString());
            return json.getString("email");
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }
}
