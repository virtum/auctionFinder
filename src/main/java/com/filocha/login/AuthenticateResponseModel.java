package com.filocha.login;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class AuthenticateResponseModel {

    private boolean isLogged;

}
