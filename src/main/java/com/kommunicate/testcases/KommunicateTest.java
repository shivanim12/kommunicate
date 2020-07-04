package com.kommunicate.testcases;

import com.kommunicate.utils.EmailUtils;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.kommunicate.pages.*;

import java.io.IOException;

public class KommunicateTest extends BaseTest {

    @BeforeTest
    public void open() throws IOException {
        openBrowser();
    }

    @BeforeMethod
    public void setup() throws Throwable {
        goTokommunicateUrl();
    }

    @AfterTest
    public void destroy() {
        webDriver.close();
    }

    @Test
    public void test_CountTheFAQsListed() {
        HomePage homePage = new HomePage(webDriver);
        try {
            int faqCount = homePage.getFaqCount();
            Assert.assertTrue(faqCount >= 20);
        } catch (Exception e) {
            String[] body =  {"Get FAQ count test failed.", e.getMessage()};
            EmailUtils.sendEmail(System.getenv("TO_EMAIL"), System.getenv("SMTP_USER_NAME"), "Error while verifying faq list",body);
            Assert.fail();
        }
    }
}
