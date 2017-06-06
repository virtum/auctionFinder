package com.filocha.security;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class SecurityTest {

    @Autowired
    private AuthenticationHandler authenticationHandler;

    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private FilterChainProxy springSecurityFilter;

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        mockMvc = webAppContextSetup(wac)
                // Enable Spring Security
                .addFilters(springSecurityFilter)
                .alwaysDo(print()).build();
    }

    @Test
    public void shouldAllowAccessToSecuredPageForPermittedUser() throws Exception {
        final String SECURED_URI = "/rest/subscriptions";

        MockHttpSession session = new MockHttpSession();
        session.setAttribute(
                HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY,
                SecurityContextHolder.getContext());

        mockMvc.perform(get(SECURED_URI).session(session))
                .andExpect(status().is4xxClientError());


        UserAuthenticateModel user = new UserAuthenticateModel();
        user.setPassword("temp");
        user.setUserName("temp");

        authenticationHandler.authenticateUserAndInitializeSessionByUsername(user);

        session = new MockHttpSession();
        session.setAttribute(
                HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY,
                SecurityContextHolder.getContext());

        mockMvc.perform(get(SECURED_URI).session(session))
                .andExpect(status().isOk());
    }

}
