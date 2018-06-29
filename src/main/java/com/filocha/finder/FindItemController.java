package com.filocha.finder;

import com.filocha.messaging.client.ClientBus;
import com.filocha.messaging.messages.finder.ItemFinderRequestMessage;
import com.filocha.messaging.messages.finder.ItemFinderResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.concurrent.CompletableFuture;

@RestController
//TODO change naming convention for this class and all related types, it creates new subscription and names are misleading
public class FindItemController {

    @Autowired
    private ClientBus clientBus;

    /**
     * Sends message to external microservice in order to create new subscription for given user and item.
     *
     * @param request incoming request
     * @return information that subscription was created
     */
    @CrossOrigin
    @RequestMapping(value = "/find", method = RequestMethod.POST)
    public DeferredResult<FindItemResponseModel> findItem(@RequestBody final FindItemRequestModel request) {
        final ItemFinderRequestMessage requestMessage = ItemFinderRequestMessage.builder()
                .item(request.getItem())
                .email(request.getEmail())
                .build();

        final CompletableFuture<ItemFinderResponseMessage> responseMessage = clientBus.sendRequest(requestMessage, ItemFinderRequestMessage.class);

        final DeferredResult<FindItemResponseModel> result = new DeferredResult<>(60000L, "Timeout");
        responseMessage.thenAcceptAsync(it -> result.setResult(FindItemResponseModel.builder()
                .response(it.getResponse())
                .build()));

        return result;
    }

}
