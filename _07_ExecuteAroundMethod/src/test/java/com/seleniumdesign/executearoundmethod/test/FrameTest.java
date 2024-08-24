package com.seleniumdesign.executearoundmethod.test;

import com.seleniumdesign.executearoundmethod.MainPage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FrameTest extends BaseTest {

    private MainPage mainPage;

    @BeforeTest
    public void setMainPage() {
        this.mainPage = new MainPage(driver);
    }

    @Test
    public void frameTest() {
        this.mainPage.goTo();
        this.mainPage.onFrameA(a -> {
            a.setFirstName("Avdhut");
            a.setLastName("Shirgaonkar");
            a.setAddress("Pune, India");
            a.setMessage("Inside Frame A");
        });

        this.mainPage.onFrameC(c -> c.setAddress("address for FrameC"));
        this.mainPage.onFrameB(b -> b.setMessage("this is for Frame B"));
    }
}
