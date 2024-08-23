package com.seleniumdesign.template.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EBayHomePage {
    private WebDriver driver;
    @FindBy(id = "gh-ac")
    private WebElement searchBox;

    @FindBy(id = "gh-btn")
    private WebElement searchBtn;

    public EBayHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void goTo() {
        this.driver.get("https://www.ebay.com/");
    }

    public void search(String product) {
        this.searchBox.sendKeys(product);
        this.searchBtn.click();
    }
}
