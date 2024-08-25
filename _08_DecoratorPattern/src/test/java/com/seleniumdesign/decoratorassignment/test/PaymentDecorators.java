package com.seleniumdesign.decoratorassignment.test;

import com.seleniumdesign.decoratorassignment.PaymentScreenPage;
import org.testng.Assert;

import java.util.function.Consumer;

public class PaymentDecorators {

    //customizations
    public static final Consumer<PaymentScreenPage> freeCoupon = (ps) -> ps.applyPromocode("FREEUDEMY");
    public static final Consumer<PaymentScreenPage> discountedCoupon = (ps) -> ps.applyPromocode("PARTIALUDEMY");
    public static final Consumer<PaymentScreenPage> validCC = (ps) -> ps.enterCC("4111111111111111", "2023", "123");
    public static final Consumer<PaymentScreenPage> invalidCC = (ps) -> ps.enterCC("4111100011111111", "2021", "670");
    public static final Consumer<PaymentScreenPage> buy = (ps) -> ps.buyProduct();

    //validations
    public static final Consumer<PaymentScreenPage> successfulPurchase = (ps) -> Assert.assertEquals(ps.getStatus(), "PASS");
    public static final Consumer<PaymentScreenPage> unsuccessfulPurchase = (ps) -> Assert.assertEquals(ps.getStatus(), "FAIL");

}
