package com.filocha.account;

import java.util.List;

public class AccountResponseModel {

    private String accountData;
    private List<String> auctions;

    public void setAccountData(String accountData) {
        this.accountData = accountData;
    }

    public String getAccountData() {
        return this.accountData;
    }

    public void setAuctions(List<String> auctions) {
        this.auctions = auctions;
    }

    public List<String> getAuctions() {
        return this.auctions;
    }
}
