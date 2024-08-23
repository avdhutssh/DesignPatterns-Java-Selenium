package com.seleniumdesign.proxy.test;

import com.seleniumdesign.proxy.PaymentOptionFactory;
import com.seleniumdesign.proxy.PaymentScreen;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.collections.Maps;

import java.util.Map;

public class PaymentScreenTest extends BaseTest {
    private PaymentScreen paymentScreen;

    @BeforeTest
    public void setPaymentScreen() {
//        System.setProperty("env", "QA");
        System.setProperty("env", "PROD");
        this.paymentScreen = new PaymentScreen(this.driver);
    }

    @Test(dataProvider = "getData")
    public void paymentTest(String option, Map<String, String> paymentDetails) {
        paymentScreen.goTo();
        paymentScreen.getUserInformation().enterDetails("Avdhut", "Shirgaonkar", "avd123@gmail.com");
        paymentScreen.setPaymentOption(PaymentOptionFactory.get(option));
        paymentScreen.pay(paymentDetails);
        String orderNumber = paymentScreen.getOrder().placeOrder();
        System.out.println("com.seleniumdesign.proxy.Order Number for " + option + " : " + orderNumber);
    }

    @DataProvider
    public Object[][] getData() {
        Map<String, String> cc = Maps.newHashMap();
        cc.put("cc", "1231231231");
        cc.put("year", "2023");
        cc.put("cvv", "123");

        Map<String, String> nb = Maps.newHashMap();
        nb.put("bank", "BOFA");
        nb.put("account", "myaccount123");
        nb.put("pin", "999");

        Map<String, String> pp = Maps.newHashMap();
        pp.put("username", "Avdhut");
        pp.put("pwd", "avdhut@7766");

        return new Object[][]{
                {"CC", cc},
                {"NB", nb},
                {"PP", pp}
        };

    }
}
