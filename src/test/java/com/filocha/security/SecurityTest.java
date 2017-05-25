package com.filocha.security;

import com.filocha.login.UserModel;
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
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class SecurityTest {

    @Autowired
    private SessionHandler sessionHandler;

    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private FilterChainProxy springSecurityFilter;

    private MockMvc mockMvc;

    private final String SECURED_URI = "/auth";

    //private final String LOGIN_PAGE_URL = "http://localhost/spring_security_login";

    @Before
    public void setUp() throws Exception {
        mockMvc = webAppContextSetup(wac)
                // Enable Spring Security
                .addFilters(springSecurityFilter)
                .alwaysDo(print()).build();
    }

    //@Test
    public void itShouldAllowAccessToSecuredPageForPermittedUser() throws Exception {
        MockHttpSession session = new MockHttpSession();
        session.setAttribute(
                HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY,
                SecurityContextHolder.getContext());

        mockMvc.perform(get(SECURED_URI).session(session))
                .andExpect(status().is4xxClientError());


        UserModel user = new UserModel();
        user.setPassword("temp");
        user.setUserName("temp");

        sessionHandler.authenticateUserAndInitializeSessionByUsername(user);

        session = new MockHttpSession();
        session.setAttribute(
                HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY,
                SecurityContextHolder.getContext());

        mockMvc.perform(get(SECURED_URI).session(session))
                .andExpect(status().isOk()).andReturn();
    }

    @Test
    public void temp() throws Exception {
        MockHttpSession session = new MockHttpSession();
        session.setAttribute(
                HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY,
                SecurityContextHolder.getContext());

        MvcResult result = mockMvc.perform(get(SECURED_URI).session(session))
                .andExpect(status().isOk()).andReturn();

        System.out.println(result.getResponse().getContentAsString());


        UserModel user = new UserModel();
        user.setPassword("temp");
        user.setUserName("temp");

        sessionHandler.authenticateUserAndInitializeSessionByUsername(user);

        session = new MockHttpSession();
        session.setAttribute(
                HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY,
                SecurityContextHolder.getContext());

        result = mockMvc.perform(get(SECURED_URI).session(session))
                .andExpect(status().isOk()).andReturn();

        System.out.println(result.getResponse().getContentAsString());
    }
}
