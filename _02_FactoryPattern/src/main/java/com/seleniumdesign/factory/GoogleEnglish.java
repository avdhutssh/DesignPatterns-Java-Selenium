package com.seleniumdesign.factory;

import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

class GoogleEnglish extends GooglePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    @FindBy(name = "q")
    private WebElement searchBox;

    @FindBy(name = "btnK")
    private WebElement searchBtn;
    
    @FindBy(css = "#rso div")
    private List<WebElement> results;

    @FindBy(id = "hdtb-tls")
    private WebElement toolBtn;

    @FindBy(id = "result-stats")
    private WebElement stat;

    public GoogleEnglish(final WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    @Override
    public void launchSite() {
        driver.get("https://www.google.com");
    }

    @Override
    public void search(String keyword) {
        for (char ch : keyword.toCharArray()) {
            Uninterruptibles.sleepUninterruptibly(5, TimeUnit.MILLISECONDS);
            searchBox.sendKeys(ch + "");
        }
        wait.until((d) -> searchBtn.isDisplayed());
        searchBtn.click();
    }

    @Override
    public int getResultsCount() {
        wait.until((d) -> results.size() > 1);
        return results.size();
    }

    @Override
    public String getResultStat() {
        this.toolBtn.click();
        return this.stat.getText();
    }
}
