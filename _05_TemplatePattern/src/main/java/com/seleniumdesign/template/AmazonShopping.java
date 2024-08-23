package com.seleniumdesign.template;

import com.seleniumdesign.template.PageObjects.AmazonHomePage;
import com.seleniumdesign.template.PageObjects.AmazonProductDescriptionPage;
import com.seleniumdesign.template.PageObjects.AmazonSearchResultPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AmazonShopping extends ShoppingTemplate {
    private WebDriver driver;
    private String product;
    private AmazonHomePage amazonHomePage;
    private AmazonSearchResultPage amazonSearchResultPagePage;
    private AmazonProductDescriptionPage amazonProductDescriptionPage;

    public AmazonShopping(WebDriver driver, String product) {
        this.driver = driver;
        this.product = product;
        this.amazonHomePage = PageFactory.initElements(driver, AmazonHomePage.class);
        this.amazonSearchResultPagePage = PageFactory.initElements(driver, AmazonSearchResultPage.class);
        this.amazonProductDescriptionPage = PageFactory.initElements(driver, AmazonProductDescriptionPage.class);
    }

    @Override
    public void launchSite() {
        this.amazonHomePage.goTo();
    }

    @Override
    public void searchProduct() {
        this.amazonHomePage.search(this.product);
    }

    @Override
    public void selectProduct() {
        this.amazonSearchResultPagePage.selectProductOnAmazon();
    }

    @Override
    public void getPrice() {
        this.amazonProductDescriptionPage.getPrice();

    }
}
