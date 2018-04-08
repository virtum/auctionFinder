package com.filocha.login;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FacebookValidatorTest {

    @Autowired
    private FacebookValidator facebookValidator;

    @Test
    public void shouldReturnEmptyStringIfAccessTokenIsInvalid() {
        // given
        final String accessToken = "invalidToken";

        //when
        final String result = facebookValidator.getEmailFromFacebook(accessToken);

        // then
        assertEquals("", result);
    }

}