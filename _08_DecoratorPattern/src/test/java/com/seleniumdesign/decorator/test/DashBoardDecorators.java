package com.seleniumdesign.decorator.test;

import com.seleniumdesign.decorator.DashboardPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;
import java.util.function.Consumer;

public class DashBoardDecorators {

    private static void shouldDisplay(List<WebElement> elements) {
        elements.forEach(ele -> Assert.assertTrue(ele.isDisplayed()));
    }

    private static void shouldNotDisplay(List<WebElement> elements) {
        elements.forEach(ele -> Assert.assertFalse(ele.isDisplayed()));
    }

    //ingredients
    private static final Consumer<DashboardPage> guestComponentPresent = (dp) -> shouldDisplay(dp.getGuestComponents());
    private static final Consumer<DashboardPage> guestComponentAbsent = (dp) -> shouldNotDisplay(dp.getGuestComponents());
    private static final Consumer<DashboardPage> superuserComponentPresent = (dp) -> shouldDisplay(dp.getSuperUserComponents());
    private static final Consumer<DashboardPage> superuserComponentAbsent = (dp) -> shouldNotDisplay(dp.getSuperUserComponents());
    private static final Consumer<DashboardPage> adminComponentPresent = (dp) -> shouldDisplay(dp.getAdminComponents());
    private static final Consumer<DashboardPage> adminComponentAbsent = (dp) -> shouldNotDisplay(dp.getAdminComponents());

    //role selection
    private static final Consumer<DashboardPage> guestSelection = (dp) -> dp.selectRole("guest");
    private static final Consumer<DashboardPage> superuserSelection = (dp) -> dp.selectRole("superuser");
    private static final Consumer<DashboardPage> adminSelection = (dp) -> dp.selectRole("admin");

    //user role pages
    public static final Consumer<DashboardPage> noRoleSelectionPage = guestComponentAbsent.andThen(superuserComponentAbsent.andThen(adminComponentAbsent));
    public static final Consumer<DashboardPage> guestPage = guestSelection.andThen(guestComponentPresent).andThen(superuserComponentAbsent).andThen(adminComponentAbsent);
    public static final Consumer<DashboardPage> superuserPage = superuserSelection.andThen(guestComponentPresent).andThen(superuserComponentPresent).andThen(adminComponentAbsent);
    public static final Consumer<DashboardPage> adminPage = adminSelection.andThen(guestComponentPresent).andThen(superuserComponentPresent).andThen(adminComponentPresent);
}
