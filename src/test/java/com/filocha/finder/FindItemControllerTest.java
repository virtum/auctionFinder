package com.filocha.finder;


import com.filocha.messaging.client.ClientBus;
import com.filocha.messaging.messages.finder.ItemFinderRequestMessage;
import com.filocha.messaging.messages.finder.ItemFinderResponseMessage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.CompletableFuture;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FindItemControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @MockBean
    private ClientBus clientBus;

    @Test
    // TODO fix this test
    public void should() {
        final String item = "itemName";
        final String email = "email";
        final String response = "Ok";

        final FindItemRequestModel restRequest = FindItemRequestModel.builder()
                .item(item)
                .email(email)
                .build();

        final ItemFinderRequestMessage jmsMessage = ItemFinderRequestMessage.builder()
                .item(item)
                .email(email)
                .build();

        final CompletableFuture<Object> jmsResponse = new CompletableFuture<>();
        jmsResponse.complete(ItemFinderResponseMessage.builder()
                .response(response)
                .build());

        when(clientBus.sendRequest(jmsMessage, ItemFinderRequestMessage.class)).thenReturn(jmsResponse);

        final String result = this.restTemplate.postForEntity("http://localhost:" + port + "/find", restRequest, ItemFinderResponseMessage.class)
                .getBody()
                .getResponse();

        assertEquals(response, result);
    }
}