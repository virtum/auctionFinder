package com.filocha.account;

import com.filocha.messaging.client.ClientBusImpl;
import com.filocha.messaging.messages.subscriptions.SubscriptionsRequestModel;
import com.filocha.messaging.messages.subscriptions.SubscriptionsResponseModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import javax.annotation.PostConstruct;
import java.security.Principal;
import java.util.concurrent.CompletableFuture;

@RestController
public class AccountController {

    private ClientBusImpl clientBus;

    @Value("${dockerPort}")
    private String dockerPort;

    @PostConstruct
    public void setClienBus() {
        clientBus = new ClientBusImpl();
        clientBus.setConsumerAndProducer(dockerPort);
    }

    @CrossOrigin
    @RequestMapping(value = "/rest/subscriptions", method = RequestMethod.GET)
    public DeferredResult<AccountResponseModel> getAccountData(Principal principal) {
        AccountResponseModel response = new AccountResponseModel();
        response.setAccountData("test");

        SubscriptionsRequestModel requestMessage = new SubscriptionsRequestModel();
        requestMessage.setEmail(principal.getName());

        CompletableFuture<SubscriptionsResponseModel> responseMessage = clientBus.sendRequest(requestMessage, SubscriptionsRequestModel.class);

        DeferredResult<AccountResponseModel> result = new DeferredResult<>(60000L, "Timeout");
        responseMessage.thenAcceptAsync(it -> {
            response.setAuctions(it.getUserSubscriptions());
            System.out.println(it.getUserSubscriptions());
            result.setResult(response);
        });
        return result;
    }
}
