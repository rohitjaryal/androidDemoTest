package com.mytaxi.android_demo.com.mytaxi.android_locators;

import android.view.View;

import com.mytaxi.android_demo.R;

import org.hamcrest.Matcher;

import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

public class AppLocators {


    public static Matcher<View> getUserName() {
        return withId(R.id.edt_username);
    }

    public static Matcher<View> getPassword() {
        return withId(R.id.edt_password);
    }

    public static Matcher<View> getLoginBtn() {
        return withId(R.id.btn_login);
    }

    public static Matcher<View> getSearchTextbox() {
        return withId(R.id.textSearch);
    }

    public static Matcher<View> getDriverNameListView(String driverName) {
        return withText(driverName);
    }

    public static Matcher<View> getNavigationDrawer() {
        return withContentDescription("Open navigation drawer");
    }

    public static Matcher<View> getLogoutBtn() {
        return withId(R.id.design_menu_item_text);
    }

    public static Matcher<View> getCallBtn() {
        return withId(R.id.fab);
    }
}
