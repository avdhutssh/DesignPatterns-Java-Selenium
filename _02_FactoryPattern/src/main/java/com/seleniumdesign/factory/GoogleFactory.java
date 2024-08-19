package com.seleniumdesign.factory;

import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class GoogleFactory {
    private static final Function<WebDriver,GooglePage> ENG = (d) -> new GoogleEnglish(d);
    private static final Function<WebDriver,GooglePage> FR = (d) -> new GoogleFrench(d);
    private static final Function<WebDriver,GooglePage> SA = (d) -> new GoogleArabic(d);
    private static final Map<String,Function<WebDriver,GooglePage>> hm = new HashMap<>();

    static {
        hm.put("ENG",ENG);
        hm.put("FR",FR);
        hm.put("SA",SA);
    }

    public static GooglePage get(String language, WebDriver driver){
        return hm.get(language).apply(driver);
    }
}
