package com.seleniumdesign.template;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ElementUtils {
    private WebDriver driver;
    private WebDriverWait wait;

    public ElementUtils(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void waitForChildWindow(int windowNumber) {
        try {
            this.wait.until(ExpectedConditions.numberOfWindowsToBe(windowNumber));
        } catch (Exception e) {
            System.err.println("Timeout occurred while waiting for the child window: " + e.getMessage());
        }

    }

    public void SwitchTowindow(int i) {
        waitForChildWindow(i);

        Integer windowNumber = i;

        String[] windowHandles = this.driver.getWindowHandles().stream().toArray(String[]::new);
        driver.switchTo().window(windowHandles[windowNumber - 1]);
    }

}
