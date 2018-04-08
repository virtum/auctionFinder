package com.filocha.logout;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.filocha.login.AuthenticateRequestModel;
import com.filocha.login.AuthenticateResponseModel;
import com.filocha.login.FacebookValidator;
import com.filocha.messaging.client.ClientBus;
import com.filocha.security.AuthenticationHandler;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import java.nio.charset.Charset;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LogoutControllerTest {

    private static final MediaType APPLICATION_JSON_UTF8 = new MediaType(
            MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));

    private final ObjectMapper mapper = new ObjectMapper();

    @MockBean
    private FacebookValidator facebookValidator;

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
        // given
        final MockMvc mockMvc = webAppContextSetup(wac)
                // Enable Spring Security
                .addFilters(springSecurityFilter)
                .alwaysDo(print()).build();

        final MockHttpSession session = new MockHttpSession();
        session.setAttribute(
                HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY,
                SecurityContextHolder.getContext());

        final String accessToken = "validToken";
        // if token is valid, facebookValidator will return valid email
        when(facebookValidator.getEmailFromFacebook(accessToken)).thenReturn("email");

        mockMvc.perform(post("/authenticate").session(session)
                .contentType(APPLICATION_JSON_UTF8)
                .content(mapper.writeValueAsString(
                        AuthenticateRequestModel
                                .builder()
                                .accessToken(accessToken)
                                .build())))
                .andExpect(content().json(mapper.writeValueAsString(
                        AuthenticateResponseModel
                                .builder()
                                .isLogged(true)
                                .build())));

        mockMvc.perform(get("/isLogged").session(session))
                .andExpect(content().json(mapper.writeValueAsString(
                        AuthenticateResponseModel
                                .builder()
                                .isLogged(true)
                                .build())));

        // when & then
        mockMvc.perform(get("/rest/logout").session(session))
                .andExpect(content().json(mapper.writeValueAsString(
                        LogoutResponseModel
                                .builder()
                                .response(false)
                                .build())));
    }

}