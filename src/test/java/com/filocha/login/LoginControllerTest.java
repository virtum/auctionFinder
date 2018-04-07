package com.filocha.login;


import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import java.nio.charset.Charset;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LoginControllerTest {

    private static final MediaType APPLICATION_JSON_UTF8 = new MediaType(
            MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));

    private final ObjectMapper mapper = new ObjectMapper();

    @MockBean
    private FacebookValidator facebookValidator;

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

    @SneakyThrows
    @Test
    public void shouldNotAuthenticateUserIfTokenIsNotValid() {
        // given
        final String accessToken = "accessToken";
        final String request = mapper.writeValueAsString(AuthenticateRequestModel
                .builder()
                .accessToken(accessToken)
                .build());

        when(facebookValidator.getEmailFromFacebook(accessToken)).thenReturn("");

        // when
        final String result = mockMvc.perform(post("/authenticate")
                .contentType(APPLICATION_JSON_UTF8)
                .content(request))
                .andReturn()
                .getResponse()
                .getContentAsString();

        final boolean isLogged = new JSONObject(result).getBoolean("logged");

        // then
        assertFalse(isLogged);
    }

    @SneakyThrows
    @Test
    public void shouldAuthenticateUser() {
        // given
        String result = mockMvc.perform(get("/isLogged"))
                .andReturn()
                .getResponse()
                .getContentAsString();

        boolean isLogged = new JSONObject(result).getBoolean("logged");

        assertFalse(isLogged);

        final String accessToken = "accessToken";
        final String request = mapper.writeValueAsString(AuthenticateRequestModel
                .builder()
                .accessToken(accessToken)
                .build());

        when(facebookValidator.getEmailFromFacebook(accessToken)).thenReturn("email");

        // when
        result = mockMvc.perform(post("/authenticate")
                .contentType(APPLICATION_JSON_UTF8)
                .content(request))
                .andReturn()
                .getResponse()
                .getContentAsString();

        isLogged = new JSONObject(result).getBoolean("logged");

        // then
        assertTrue(isLogged);
    }

}