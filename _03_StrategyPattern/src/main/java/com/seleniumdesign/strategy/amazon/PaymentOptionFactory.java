package com.seleniumdesign.strategy.amazon;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class PaymentOptionFactory {

    private static final Supplier<PaymentOption> CC = () -> new CreditCard();
    private static final Supplier<PaymentOption> NB = () -> new NetBanking();
    private static final Supplier<PaymentOption> PP = () -> new PayPal();

    private static final Map<String, Supplier<PaymentOption>> hs = new HashMap<>();

    static {
        hs.put("CC", CC);
        hs.put("NB", NB);
        hs.put("PP", PP);
    }

    public static PaymentOption get(String option) {
        return hs.get(option).get();
    }
}
