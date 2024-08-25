package com.seleniumdesign.decoratorassignment.test;

import com.google.common.util.concurrent.Uninterruptibles;
import com.seleniumdesign.decorator.test.BaseTest;
import com.seleniumdesign.decoratorassignment.PaymentScreenPage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

import static com.seleniumdesign.decoratorassignment.test.PaymentDecorators.*;

public class PaymentScreenTest extends BaseTest {
    private PaymentScreenPage paymentScreenPage;

    @BeforeTest
    public void setPaymentScreenPage() {
        this.paymentScreenPage = new PaymentScreenPage(driver);
    }

    @Test(dataProvider = "getData")
    public void paymentScreenTest(Consumer<PaymentScreenPage> consumer) {
        paymentScreenPage.goTo();
        consumer.accept(paymentScreenPage);

        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
    }

    @DataProvider
    public Object[] getData() {
        return new Object[]{
                validCC.andThen(buy).andThen(successfulPurchase),
                discountedCoupon.andThen(validCC).andThen(buy).andThen(successfulPurchase),
                freeCoupon.andThen(buy).andThen(successfulPurchase),
                discountedCoupon.andThen(invalidCC).andThen(buy).andThen(unsuccessfulPurchase),
                invalidCC.andThen(buy).andThen(unsuccessfulPurchase),
                buy.andThen(unsuccessfulPurchase)
        };
    }

}
