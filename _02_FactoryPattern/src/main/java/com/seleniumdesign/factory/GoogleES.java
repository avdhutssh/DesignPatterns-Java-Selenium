package com.seleniumdesign.factory;

import org.openqa.selenium.WebDriver;

class GoogleES extends GoogleEnglish {
    public GoogleES(WebDriver driver) {
        super(driver);
    }

    @Override
    public void launchSite() {
        driver.get("https://www.google.es");
        language.click();
    }
}
