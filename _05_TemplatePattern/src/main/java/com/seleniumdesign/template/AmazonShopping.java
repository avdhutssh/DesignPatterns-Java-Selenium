package com.seleniumdesign.template;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AmazonShopping extends ShoppingTemplate {
    private WebDriver driver;
    private WebDriverWait wait;
    private String product;
    private ElementUtils elementUtils;


    @FindBy(id = "twotabsearchtextbox")
    private WebElement searchBox;

    @FindBy(css = "input#nav-search-submit-button")
    private WebElement searchBtn;

    @FindBy(css = "h2 span.a-size-medium")
    private WebElement item;

    @FindBy(xpath = "//span[@class='a-price aok-align-center reinventPricePriceToPayMargin priceToPay']//span[@class='a-price-whole']")
    private WebElement price;

    public AmazonShopping(WebDriver driver, String product) {
        this.driver = driver;
        this.product = product;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
        this.elementUtils = PageFactory.initElements(driver, ElementUtils.class);

    }

    @Override
    public void launchSite() {
        this.driver.get("https://amazon.in/");
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
        this.wait.until((d) -> this.price.isDisplayed());
        System.out.println("Price on Amazon is: " + this.price.getText());
        driver.close();
        elementUtils.SwitchTowindow(1);

    }
}
