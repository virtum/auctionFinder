package com.filocha.finder;

import com.filocha.messaging.client.ClientBusImpl;
import com.filocha.messaging.messages.finder.ItemFinderRequestMessage;
import com.filocha.messaging.messages.finder.ItemFinderResponseMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.DeferredResult;

import javax.annotation.PostConstruct;
import java.security.Principal;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
public class FindItemController {

    private ClientBusImpl clientBus;

    @Value("${dockerPort}")
    private String dockerPort;

    @PostConstruct
    public void setClienBus() {
        clientBus = new ClientBusImpl();
        clientBus.setConsumerAndProducer(dockerPort);
    }

    @CrossOrigin
    @RequestMapping(value = "/rest/find", method = RequestMethod.POST)
    public DeferredResult<FindItemResponseModel> findItem(@RequestBody FindItemRequestModel itemRequestModel, Principal principal) throws ExecutionException, InterruptedException {
        ItemFinderRequestMessage requestMessage = new ItemFinderRequestMessage();
        requestMessage.setItem(itemRequestModel.getItem());
        requestMessage.setEmail(principal.getName());

        CompletableFuture<ItemFinderResponseMessage> responseMessage = clientBus.sendRequest(requestMessage, ItemFinderRequestMessage.class);

        FindItemResponseModel response = new FindItemResponseModel();

        DeferredResult<FindItemResponseModel> result = new DeferredResult<>(60000L, "Timeout");
        responseMessage.thenAcceptAsync(it -> {
            response.setResponse("Received from backend: " + it.getResponse());
            System.out.println(it.getResponse());
            result.setResult(response);
        });
        return result;
    }

}
