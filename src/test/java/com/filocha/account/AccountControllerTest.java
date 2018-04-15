package com.filocha.account;

import com.filocha.messaging.client.ClientBus;
import com.filocha.messaging.messages.subscriptions.Subscription;
import com.filocha.messaging.messages.subscriptions.SubscriptionsRequestModel;
import com.filocha.messaging.messages.subscriptions.SubscriptionsResponseModel;
import com.filocha.security.AuthenticationHandler;
import com.filocha.security.UserAuthenticateModel;
import lombok.SneakyThrows;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import java.util.Collections;
import java.util.concurrent.CompletableFuture;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AccountControllerTest {

    @Autowired
    private AuthenticationHandler authenticationHandler;
    @Autowired
    private WebApplicationContext wac;
    @Autowired
    private FilterChainProxy springSecurityFilter;

    @MockBean
    private ClientBus clientBus;

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        mockMvc = webAppContextSetup(wac)
                // Enable Spring Security
                .addFilters(springSecurityFilter)
                .alwaysDo(print()).build();
    }

    @SneakyThrows
    @Test
    public void shouldGetAccountData() {
        // given
        final String email = "userEmail";
        final String subscriptionItem = "item";

        // mock authentication
        authenticationHandler.authenticateUserAndInitializeSessionByUsername(UserAuthenticateModel.builder()
                .password("password")
                .userName(email)
                .build());

        final MockHttpSession sessionWithAuthorization = new MockHttpSession();
        sessionWithAuthorization.setAttribute(
                HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY,
                SecurityContextHolder.getContext());

        final CompletableFuture<Object> jmsResponse = new CompletableFuture<>();
        jmsResponse.complete(SubscriptionsResponseModel
                .builder()
                .userSubscriptions(Collections.singletonList(
                        Subscription
                                .builder()
                                .itemName(subscriptionItem)
                                .build()))
                .build());

        when(clientBus
                .sendRequest(SubscriptionsRequestModel
                        .builder()
                        .email(email)
                        .build(), SubscriptionsRequestModel.class))
                .thenReturn(jmsResponse);

        // when
        final AccountResponseModel result = (AccountResponseModel) mockMvc.perform(get("/rest/subscriptions")
                .session(sessionWithAuthorization))
                .andReturn()
                .getAsyncResult();

        // then
        assertEquals(1, result.getUserSubscriptions().size());
        assertEquals(subscriptionItem, result.getUserSubscriptions().get(0).getItemName());
    }

}