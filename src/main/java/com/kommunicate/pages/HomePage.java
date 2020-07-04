package com.kommunicate.pages;

import com.kommunicate.testcases.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class HomePage extends BaseTest {

    private WebDriver webDriver;


    public HomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public int getFaqCount() throws Exception {
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, 10);
        WebDriver chatBoxFrame = webDriverWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//*[@name='Kommunicate widget iframe']")));
        WebDriverWait webDriverWait2 = new WebDriverWait(webDriver, 10);
        webDriverWait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='launcher-svg-container']")));
        WebElement chatBox = chatBoxFrame.findElement(By.xpath("//*[@id='launcher-svg-container']"));
        chatBox.click();
        WebDriverWait webDriverWait3 = new WebDriverWait(webDriver, 60);
        webDriverWait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='km-kb-container vis']/button[@id='km-faq']")));
        WebElement faqButton = chatBox.findElement(By.xpath("//div[@class='km-kb-container vis']/button[@id='km-faq']"));
        faqButton.click();
        List<WebElement> faqsList = chatBox.findElements(By.xpath("//div[@id='km-faqdiv']/ul[@id='km-faq-list-container']/li[@class='km-faq-list']"));
        if (faqsList.size() < 20) {
            throw new Exception("FAQ list size is less than 20");
        }
        return faqsList.size();
    }


}
