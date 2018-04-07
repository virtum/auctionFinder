package com.filocha.account;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class AccountResponseModel {

    private String accountData;
    private List<String> auctions;

}
