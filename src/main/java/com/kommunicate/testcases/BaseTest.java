package com.kommunicate.testcases;

import static com.kommunicate.constants.Constants.*;
import com.kommunicate.utils.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class BaseTest {
    protected WebDriver webDriver;
    public void openBrowser()
    {
        String browserType=System.getenv(BROWSER);
        if(browserType.equalsIgnoreCase("chrome"))
            System.setProperty(System.getenv(DRIVER_TYPE), System.getenv(DRIVER_PATH));
            webDriver =new ChromeDriver();

    }

    public void goTokommunicateUrl() throws Throwable {
        String url= FileUtils.getPropertyValue("url");
        webDriver.get(url);
        webDriver.manage().window().maximize();
    }
}
