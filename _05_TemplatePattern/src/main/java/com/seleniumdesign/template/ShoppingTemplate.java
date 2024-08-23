package com.seleniumdesign.template;

public abstract class ShoppingTemplate {

    public abstract void launchSite();

    public abstract void searchProduct();

    public abstract void selectProduct();

    public abstract void getPrice();

    public void shop() {
        launchSite();
        searchProduct();
        selectProduct();
        getPrice();
    }
}
