package com.filocha.security;

import com.filocha.messaging.client.ClientBus;
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

import java.util.concurrent.CompletableFuture;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SecurityTest {

    @Autowired
    private AuthenticationHandler authenticationHandler;
    @Autowired
    private WebApplicationContext wac;
    @Autowired
    private FilterChainProxy springSecurityFilter;

    @MockBean
    private ClientBus clientBus;

    @Test
    public void shouldAllowAccessToSecuredPageForPermittedUser() throws Exception {
        final MockMvc mockMvc = webAppContextSetup(wac)
                // Enable Spring Security
                .addFilters(springSecurityFilter)
                .alwaysDo(print()).build();

        final String securedUri = "/rest/subscriptions";

        final MockHttpSession sessionWithoutAuthorization = new MockHttpSession();
        sessionWithoutAuthorization.setAttribute(
                HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY,
                SecurityContextHolder.getContext());

        mockMvc.perform(get(securedUri).session(sessionWithoutAuthorization))
                .andExpect(status().is4xxClientError());

        authenticationHandler.authenticateUserAndInitializeSessionByUsername(UserAuthenticateModel.builder()
                .password("password")
                .userName("userName")
                .build());

        when(clientBus.sendRequest(any(), any())).thenReturn(new CompletableFuture<>());

        final MockHttpSession sessionWithAuthorization = new MockHttpSession();
        sessionWithAuthorization.setAttribute(
                HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY,
                SecurityContextHolder.getContext());

        mockMvc.perform(get(securedUri).session(sessionWithAuthorization))
                .andExpect(status().isOk());
    }

}
