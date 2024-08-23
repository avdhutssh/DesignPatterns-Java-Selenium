package com.seleniumdesign.template.PageObjects;

import com.seleniumdesign.template.ElementUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EBayProductDescriptionPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private ElementUtils elementUtils;

    @FindBy(css = "div.x-price-primary span.ux-textspans")
    private WebElement price;

    public EBayProductDescriptionPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        this.elementUtils = PageFactory.initElements(driver, ElementUtils.class);
    }

    public void getPrice() {
        elementUtils.SwitchTowindow(2);
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        this.wait.until((d) -> this.price.isDisplayed());
        System.out.println("Price on Ebay is: " + this.price.getText());
        driver.close();
        elementUtils.SwitchTowindow(1);

    }
}
