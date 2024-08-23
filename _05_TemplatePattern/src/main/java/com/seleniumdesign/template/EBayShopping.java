package com.seleniumdesign.template;

import com.seleniumdesign.template.PageObjects.EBayHomePage;
import com.seleniumdesign.template.PageObjects.EBayProductDescriptionPage;
import com.seleniumdesign.template.PageObjects.EBaySearchResultPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class EBayShopping extends ShoppingTemplate {
    private WebDriver driver;
    private String product;
    private EBayHomePage EBayHomePage;
    private EBaySearchResultPage EBaySearchResultPagePage;
    private EBayProductDescriptionPage EBayProductDescriptionPage;

    public EBayShopping(WebDriver driver, String product) {
        this.driver = driver;
        this.product = product;
        this.EBayHomePage = PageFactory.initElements(driver, EBayHomePage.class);
        this.EBaySearchResultPagePage = PageFactory.initElements(driver, EBaySearchResultPage.class);
        this.EBayProductDescriptionPage = PageFactory.initElements(driver, EBayProductDescriptionPage.class);
    }

    @Override
    public void launchSite() {
        this.EBayHomePage.goTo();
    }

    @Override
    public void searchProduct() {
        this.EBayHomePage.search(this.product);
    }

    @Override
    public void selectProduct() {
        this.EBaySearchResultPagePage.selectProductOnEBay();
    }

    @Override
    public void getPrice() {
        this.EBayProductDescriptionPage.getPrice();

    }
}
