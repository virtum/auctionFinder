package com.filocha.login;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Objects;

@Service
public class FacebookValidator {

    /***
     * Sends request via http to facebook to get user e-mail using accessToken.
     *
     * @param accessToken token received after login to facebook
     * @return user e-mail, in case of exception empty string
     */
    public String getEmailFromFacebook(String accessToken) {
        final String url = "https://graph.facebook.com/me?fields=email&access_token=" + accessToken;

        try {
            final URL obj = new URL(url);
            final HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            // optional default is GET
            con.setRequestMethod("GET");

            //add request header
            con.setRequestProperty("User-Agent", "Mozilla/5.0");

            final BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            final StringBuilder response = new StringBuilder();

            while (Objects.nonNull(inputLine = in.readLine())) {
                response.append(inputLine);
            }
            in.close();

            return new JSONObject(response.toString())
                    .getString("email");
        } catch (IOException | JSONException e) {
            return "";
        }
    }
}
