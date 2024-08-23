package com.seleniumdesign.proxy;

import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Objects;

public class OrderComponentProxy implements OrderComponent {
    private static final List<String> EXCLUDED = List.of("PROD", "STAGING");
    private OrderComponent orderComponent;

    public OrderComponentProxy(final WebDriver driver) {
        String currentEnv = System.getProperty("env");  //DEV, QA, PROD, STAGING
        if (!EXCLUDED.contains(currentEnv)) {
            this.orderComponent = new OrderComponentReal(driver);
        }
    }

    @Override
    public String placeOrder() {
        if (Objects.nonNull(this.orderComponent)) {
            return this.orderComponent.placeOrder();
        } else {
            return "SKIPPED";
        }
    }
}
