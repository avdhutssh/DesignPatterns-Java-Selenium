package com.seleniumdesign.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

class GoogleArabic extends GoogleEnglish {

    @FindBy(css = "span.ly0Ckb")
    private WebElement keyboardBtn;

    @FindBy(id = "kbd")
    private WebElement keyboard;

    public GoogleArabic(WebDriver driver) {
        super(driver);
    }

    @Override
    public void launchSite() {
        this.driver.get("https://www.google.com.sa");
        this.language.click();
    }

    @Override
    public void search(String keyword) {
        wait.until((d) -> this.keyboardBtn.isDisplayed());
        keyboardBtn.click();
        wait.until((d) -> this.keyboard.isDisplayed());
        super.search(keyword);
    }
}
