package com.filocha.account;

import com.filocha.messaging.messages.subscriptions.Subscription;
import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class AccountResponseModel {

    private List<Subscription> userSubscriptions;
    private Long subscriptionCounter;

}
