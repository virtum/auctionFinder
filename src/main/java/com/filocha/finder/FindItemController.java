package com.filocha.finder;

import com.filocha.messaging.client.ClientBusImpl;
import com.filocha.messaging.messages.finder.ItemFinderRequestMessage;
import com.filocha.messaging.messages.finder.ItemFinderResponseMessage;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.DeferredResult;

import javax.annotation.PostConstruct;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
public class FindItemController {

    private ClientBusImpl clientBus;

    @PostConstruct
    public void setClienBus() {
        clientBus = new ClientBusImpl();
        clientBus.setConsumerAndProducer("failover://tcp://192.168.99.100:61616");
    }

    @CrossOrigin
    @RequestMapping(value = "find", method = RequestMethod.POST)
    public DeferredResult<FindItemResponseModel> findItem(@RequestBody FindItemRequestModel itemRequestModel) throws ExecutionException, InterruptedException {
        ItemFinderRequestMessage requestMessage = new ItemFinderRequestMessage();
        requestMessage.setItemName(itemRequestModel.getItemName());

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
