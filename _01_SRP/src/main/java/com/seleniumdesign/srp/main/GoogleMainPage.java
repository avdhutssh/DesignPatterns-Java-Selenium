package com.seleniumdesign.srp.main;

import com.seleniumdesign.srp.common.SearchSuggestion;
import com.seleniumdesign.srp.common.SearchWidget;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class GoogleMainPage {
    private WebDriver driver;
    private SearchWidget searchWidget;
    private SearchSuggestion searchSuggestion;

     public GoogleMainPage(final WebDriver driver){
         this.driver = driver;
         this.searchWidget = PageFactory.initElements(driver,SearchWidget.class);
         this.searchSuggestion = PageFactory.initElements(driver, SearchSuggestion.class);
     }

     public void goTo(){
         driver.get("https://www.google.com");
    }

    public SearchWidget getSearchWidget() {
        return searchWidget;
    }

    public SearchSuggestion getSearchSuggestion() {
        return searchSuggestion;
    }
}
