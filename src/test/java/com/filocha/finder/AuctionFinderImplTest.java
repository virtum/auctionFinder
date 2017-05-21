package com.filocha.finder;

import com.filocha.messaging.client.ClientBusImpl;
import com.filocha.messaging.server.ServerBusImpl;
import org.apache.log4j.BasicConfigurator;
import org.junit.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

//@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AuctionFinderImplTest {

    //@Autowired
    private AuctionFinderImpl auctionFinder;

//    @Test
//    public void shouldFindAnyAuction() {
//        List<ItemsListType> auctions = auctionFinder.findAuctions("nokia");
//        assertThat(auctions.size(), greaterThan(0));
//    }

    @Test
    public void shouldSendAndReceiveMessageViaActiveMQ() throws ExecutionException, InterruptedException {
        BasicConfigurator.configure();

        ServerBusImpl serverBus = new ServerBusImpl();
        serverBus.setConsumerAndProducer("failover://tcp://localhost:61616");
        serverBus.addHandler(it -> it + " world", String.class, String.class);

        ClientBusImpl clientBus = new ClientBusImpl();
        clientBus.setConsumerAndProducer("failover://tcp://localhost:61616");
        CompletableFuture<String> future = clientBus.sendRequest("hello", String.class);

        String response = future.get();

        assertThat(response, equalTo("hello world"));
    }

}
