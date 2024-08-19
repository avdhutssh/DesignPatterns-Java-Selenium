package com.seleniumdesign.factory.test;

import com.seleniumdesign.factory.GoogleFactory;
import com.seleniumdesign.factory.GooglePage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GoogleSearchTest extends BaseTest {

    private GooglePage googlePage;

    @Test(dataProvider = "getData")
    public void searchTest(String language, String keyword) {
        googlePage = GoogleFactory.get(language, driver);
        googlePage.launchSite();
        googlePage.search(keyword);
        int count = googlePage.getResultsCount();
        System.out.println(count);
        System.out.println(googlePage.getResultStat());

    }

    @DataProvider
    public Object[][] getData() {
        return new Object[][]{
                {"ENG", "Selenium"},
                {"FR", "Selenium"},
                {"SA", "Selenium"}
        };
    }
}
