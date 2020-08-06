package com.kommunicate.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class KommunicateHomePage {

    private WebDriver webDriver;


    public KommunicateHomePage (WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void sendChatMessage() {
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, 30);
        WebDriver chatBoxFrame = webDriverWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//*[@name='Kommunicate widget iframe']")));
        WebDriverWait webDriverWait2 = new WebDriverWait(webDriver, 30);
        webDriverWait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='launcher-svg-container']")));
        WebElement chatBox = chatBoxFrame.findElement(By.xpath("//*[@id='launcher-svg-container']"));
        chatBox.click();
        WebDriverWait webDriverWait3 = new WebDriverWait(webDriver, 30);
        webDriverWait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='mck-text-box']")));
        WebElement textBox = chatBox.findElement(By.xpath("//*[@id='mck-text-box']"));
        textBox.sendKeys("Hi");
        textBox.sendKeys(Keys.RETURN);
    }
}
