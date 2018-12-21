package com.rentaladda.controller;

import com.rentaladda.controller.HomeController;
import org.junit.Test;
import org.junit.experimental.theories.Theories;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.model.Statement;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.*;

import static org.junit.Assert.*;
import java.util.Arrays;

@RunWith(Parameterized.class)
public class HomeControllerTest implements TestRule {

        private String emailId;
        private boolean expected;

        public HomeControllerTest(String emailId, boolean expected){
            this.emailId = emailId;
            this.expected = expected;
        }

        @Override
            public Statement apply (Statement statement, Description description){
            return null;
        }

            @Parameterized.Parameters(name = "{index}: isValidated({0})={1}")
            public static Iterable<Object[]> data () {
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
            public void testIsValidEmailId () throws Exception {
            boolean actual = HomeController.isValid(emailId);
            assertThat(actual, is(equalTo(expected)));
        }

}

