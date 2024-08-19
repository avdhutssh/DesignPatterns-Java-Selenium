package com.seleniumdesign.factory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public abstract class GooglePage {

    @FindBy(xpath = "(//div[@id='SIvCob']//a)[1]")
    protected WebElement language;

    public abstract void launchSite();

    public abstract void search(String keyword);

    public abstract int getResultsCount();

    public abstract String getResultStat();


}
