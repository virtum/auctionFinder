package com.filocha.account;

import com.filocha.messaging.client.ClientBus;
import com.filocha.messaging.messages.subscriptions.SubscriptionsRequestModel;
import com.filocha.messaging.messages.subscriptions.SubscriptionsResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.security.Principal;
import java.util.concurrent.CompletableFuture;

@RestController
public class AccountController {

    @Autowired
    private ClientBus clientBus;

    @CrossOrigin
    @RequestMapping(value = "/rest/subscriptions", method = RequestMethod.GET)
    public DeferredResult<AccountResponseModel> getAccountData(Principal principal) {
        SubscriptionsRequestModel requestMessage = SubscriptionsRequestModel
                .builder()
                .email(principal.getName())
                .build();

        CompletableFuture<SubscriptionsResponseModel> responseMessage = clientBus.sendRequest(requestMessage, SubscriptionsRequestModel.class);

        DeferredResult<AccountResponseModel> result = new DeferredResult<>(60000L, "Timeout");
        responseMessage.thenAcceptAsync(it -> result.setResult(AccountResponseModel
                .builder()
                .auctions(it.getUserSubscriptions())
                .accountData("test")
                .build()));

        return result;
    }
}
