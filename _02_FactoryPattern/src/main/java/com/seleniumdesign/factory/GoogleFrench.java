package com.seleniumdesign.factory;

import org.openqa.selenium.WebDriver;

class GoogleFrench extends GoogleEnglish {
    public GoogleFrench(WebDriver driver) {
        super(driver);
    }

    @Override
    public void launchSite() {
        driver.get("https://www.google.fr");
        language.click();
    }

}
