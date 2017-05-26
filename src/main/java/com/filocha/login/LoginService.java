package com.filocha.login;

import java.security.Principal;

public interface LoginService {

    boolean handleLogin(String accessToken);

    boolean checkIfUserIsLogged(Principal principal);
}
