package com.seleniumdesign.template.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AmazonSearchResultPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(css = "h2 span.a-size-medium")
    private WebElement item;

    public AmazonSearchResultPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void selectProductOnAmazon() {
        this.wait.until((d) -> this.item.isDisplayed());
        this.item.click();
    }
}
