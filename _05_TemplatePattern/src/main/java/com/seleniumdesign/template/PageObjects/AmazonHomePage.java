package com.seleniumdesign.template.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AmazonHomePage {
    private WebDriver driver;
    @FindBy(id = "twotabsearchtextbox")
    private WebElement searchBox;

    @FindBy(css = "input#nav-search-submit-button")
    private WebElement searchBtn;

    public AmazonHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void goTo() {
        this.driver.get("https://amazon.in/");
    }

    public void search(String product) {
        this.searchBox.sendKeys(product);
        this.searchBtn.click();
    }
}
