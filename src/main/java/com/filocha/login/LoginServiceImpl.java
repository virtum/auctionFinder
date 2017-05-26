package com.filocha.login;

import com.filocha.security.SessionHandler;
import com.filocha.security.UserAuthenticateModel;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private SessionHandler sessionHandler;

    @Override
    public boolean handleLogin(String accessToken) {
        String email = getEmailFromFacebook(accessToken);

        AuthenticateResponseModel response = new AuthenticateResponseModel();
        if (email.equals("")) {
            return false;
        }

        UserAuthenticateModel user = new UserAuthenticateModel();
        user.setPassword(accessToken);
        user.setUserName(email);

        return sessionHandler.authenticateUserAndInitializeSessionByUsername(user);
    }

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
