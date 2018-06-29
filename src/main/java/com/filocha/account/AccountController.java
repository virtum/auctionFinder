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

    /**
     * Retrieves data for given user of all subscriptions from external microservice through messaging.
     *
     * @param request incoming request message
     * @return details of user's subscriptions
     */
    @CrossOrigin
    @RequestMapping(value = "/rest/subscriptions", method = RequestMethod.GET)
    public DeferredResult<AccountResponseModel> getAccountData(final Principal request) {
        final SubscriptionsRequestModel requestMessage = SubscriptionsRequestModel
                .builder()
                .email(request.getName())
                .build();

        final DeferredResult<AccountResponseModel> result = new DeferredResult<>(60000L, "Timeout");

        final CompletableFuture<SubscriptionsResponseModel> responseMessage = clientBus.sendRequest(requestMessage, SubscriptionsRequestModel.class);
        responseMessage.thenAcceptAsync(it -> result.setResult(AccountResponseModel
                .builder()
                .userSubscriptions(it.getUserSubscriptions())
                .subscriptionCounter(it.getUserSubscriptions().size())
                .build()));

        return result;
    }
}
