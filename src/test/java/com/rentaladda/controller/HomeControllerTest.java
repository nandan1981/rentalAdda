package com.rentaladda.controller;

import com.rentaladda.controller.HomeController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.hamcrest.CoreMatchers.*;

import static org.junit.Assert.*;
import java.util.Arrays;

@RunWith(Parameterized.class)
public class HomeControllerTest {

    private String emailId;
    private boolean expected;

    public HomeControllerTest(String emailId, boolean expected) {
        this.emailId = emailId;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "{index}: isValid({0})={1}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{
                        {"mary@testdomain.com", true},
                        {"mary.smith@testdomain.com", true},
                        {"mary_smith123@testdomain.com", true},
                        {"mary@testdomaindotcom", false},
                        {"mary-smith@testdomain", false},
                        {"testdomain.com", false}
                }
        );
    }

    @Test
    public void testIsValidEmailId() throws Exception {
        boolean actual= HomeController.isValid(emailId);
        assertThat(actual, is(equalTo(expected)));
    }
}
