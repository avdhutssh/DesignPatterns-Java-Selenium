package com.seleniumdesign.template.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EBaySearchResultPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "(//div[@class='s-item__info clearfix']/a)[3] ")
    private WebElement item;

    public EBaySearchResultPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void selectProductOnEBay() {
        this.wait.until((d) -> this.item.isDisplayed());
        this.item.click();
    }
}
