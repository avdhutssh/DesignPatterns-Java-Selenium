package com.seleniumdesign.command.test;

import com.seleniumdesign.command.ElementValidator;
import com.seleniumdesign.command.HomePage;
import com.seleniumdesign.strategy.test.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HomePageTestUsingDataProvider extends BaseTest {

    private HomePage homePage;

    @BeforeTest
    public void setHomePage() {
        this.homePage = new HomePage(driver);
    }

    @Test
    public void goTo() {
        this.homePage.goTo();
    }

    @Test(dataProvider = "getData", dependsOnMethods = "goTo")
    public void homePageTest(ElementValidator elementValidator) {
        Assert.assertTrue(elementValidator.validate());
    }

    @DataProvider
    public Object[] getData() {
        return this.homePage.getElementValidators()
                .toArray();
    }
}
