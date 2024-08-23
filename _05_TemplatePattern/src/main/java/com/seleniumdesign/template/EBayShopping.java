package com.seleniumdesign.template;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EBayShopping extends ShoppingTemplate {
    private WebDriver driver;
    private WebDriverWait wait;
    private String product;
    private ElementUtils elementUtils;

    @FindBy(id = "gh-ac")
    private WebElement searchBox;

    @FindBy(id = "gh-btn")
    private WebElement searchBtn;

    @FindBy(xpath = "(//div[@class='s-item__info clearfix']/a)[3] ")
    private WebElement item;

    @FindBy(css = "div.x-price-primary span.ux-textspans")
    private WebElement price;

    public EBayShopping(WebDriver driver, String product) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        this.product = product;
        PageFactory.initElements(driver, this);
        this.elementUtils = PageFactory.initElements(driver, ElementUtils.class);
    }

    @Override
    public void launchSite() {
        this.driver.get("https://www.ebay.com/");
    }

    @Override
    public void searchProduct() {
        this.searchBox.sendKeys(this.product);
        this.searchBtn.click();
    }

    @Override
    public void selectProduct() {
        this.wait.until((d) -> this.item.isDisplayed());
        this.item.click();
    }

    @Override
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
