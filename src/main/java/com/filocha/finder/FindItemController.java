package com.filocha.finder;

import com.filocha.messaging.client.ClientBus;
import com.filocha.messaging.messages.finder.ItemFinderRequestMessage;
import com.filocha.messaging.messages.finder.ItemFinderResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.concurrent.CompletableFuture;

@RestController
public class FindItemController {

    @Autowired
    private ClientBus clientBus;

    @CrossOrigin
    @RequestMapping(value = "/find", method = RequestMethod.POST)
    public DeferredResult<FindItemResponseModel> findItem(@RequestBody final FindItemRequestModel itemRequestModel) {
        final ItemFinderRequestMessage requestMessage = ItemFinderRequestMessage.builder()
                .item(itemRequestModel.getItem())
                .email(itemRequestModel.getEmail())
                .build();

        final CompletableFuture<ItemFinderResponseMessage> responseMessage = clientBus.sendRequest(requestMessage, ItemFinderRequestMessage.class);

        final FindItemResponseModel response = new FindItemResponseModel();

        final DeferredResult<FindItemResponseModel> result = new DeferredResult<>(60000L, "Timeout");
        responseMessage.thenAcceptAsync(it -> {
            response.setResponse(it.getResponse());
            System.out.println(it.getResponse());
            result.setResult(response);
        });
        
        return result;
    }

}
