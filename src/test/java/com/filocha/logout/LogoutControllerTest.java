package com.filocha.logout;

import com.filocha.messaging.client.ClientBus;
import com.filocha.security.AuthenticationHandler;
import com.filocha.security.UserAuthenticateModel;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class LogoutControllerTest {

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

        authenticationHandler.authenticateUserAndInitializeSessionByUsername(UserAuthenticateModel.builder()
                .password("password")
                .userName("userName")
                .build());

        final MockHttpSession sessionWithAuthorization = new MockHttpSession();
        sessionWithAuthorization.setAttribute(
                HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY,
                SecurityContextHolder.getContext());

        mockMvc.perform(get("/rest/logout").session(sessionWithAuthorization))
                .andExpect(status().isOk());
    }

}