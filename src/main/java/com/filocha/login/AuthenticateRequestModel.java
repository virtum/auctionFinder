package com.filocha.login;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class AuthenticateRequestModel {
    
    private String accessToken;

}
