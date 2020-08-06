package com.kommunicate.testcases;

import com.kommunicate.pages.KommunicateHomePage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class KommunicateInterviewTest extends BaseTest {

    @BeforeTest
    public void setup() throws Throwable {
        openBrowser();
        goTokommunicateUrl();
    }


    @Test
    public void Test_sendTextMessageInHelpChat(){
        KommunicateHomePage kommunicateHomePage = new KommunicateHomePage(webDriver);
        kommunicateHomePage.sendChatMessage();
    }

}
