package com.seleniumdesign.template.PageObjects;

import com.seleniumdesign.template.ElementUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AmazonProductDescriptionPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private ElementUtils elementUtils;

    @FindBy(xpath = "//span[@class='a-price aok-align-center reinventPricePriceToPayMargin priceToPay']//span[@class='a-price-whole']")
    private WebElement price;

    public AmazonProductDescriptionPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        this.elementUtils = PageFactory.initElements(driver, ElementUtils.class);
    }

    public void getPrice() {
        elementUtils.SwitchTowindow(2);
        System.out.println(driver.getTitle());
        this.wait.until((d) -> this.price.isDisplayed());
        System.out.println("Price on Amazon is: " + this.price.getText());
        driver.close();
        elementUtils.SwitchTowindow(1);

    }
}
