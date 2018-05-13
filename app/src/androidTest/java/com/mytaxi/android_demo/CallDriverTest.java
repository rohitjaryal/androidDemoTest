package com.mytaxi.android_demo;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.DataInteraction;
import android.support.test.espresso.matcher.BoundedMatcher;
import android.support.test.espresso.matcher.RootMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.TextView;

import com.mytaxi.android_demo.activities.DriverProfileActivity;
import com.mytaxi.android_demo.activities.MainActivity;
import com.mytaxi.android_demo.adapters.DriverAdapter;
import com.mytaxi.android_demo.com.mytaxi.android_locators.AppLocators;
import com.mytaxi.android_demo.models.Driver;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.hamcrest.TypeSafeMatcher;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.doesNotExist;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.core.internal.deps.dagger.internal.Preconditions.checkNotNull;
import static android.support.test.espresso.core.internal.deps.guava.base.Preconditions.checkArgument;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.anything;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.collection.IsMapContaining.hasEntry;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(AndroidJUnit4.class)
public class CallDriverTest {

    String searchString="sa";
    String driverName="Sarah Friedrich";
    String userName="whiteelephant261";
    String password="video1";

    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule=
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();
        assertEquals("com.mytaxi.android_demo", appContext.getPackageName());
    }


    @Test
    public void step1_verifyLogin() throws Exception {
        // ------------- For valid user

        onView(AppLocators.getUserName())
                .check(matches(isDisplayed()))
                .perform(typeText(userName));

        onView(AppLocators.getPassword())
                .check(matches(isDisplayed()))
                .perform(typeText(password));

        onView(AppLocators.getLoginBtn())
                .check(matches(isDisplayed()))
                .perform(click());
    }

    @Test
    public void step2_verifySearch() throws Exception {
        // Searching for particular Driver

        Thread.sleep(15000);
        onView(AppLocators.getSearchTextbox())
                .perform(typeText(searchString), closeSoftKeyboard());

        onView(AppLocators.getDriverNameListView(driverName))
                .inRoot(withDecorView(not(Matchers.is(mainActivityActivityTestRule.getActivity().getWindow().getDecorView()))))
                .perform(scrollTo())
                .check(matches(isDisplayed()))
                .perform(click());


        Thread.sleep(5000);
        onView(AppLocators.getCallBtn())
                .check(matches(isDisplayed()))
                .perform(click());
        Thread.sleep(5000);

/*
        onData(withText(driverName))
                .inRoot(withDecorView(not(Matchers.is(menuActivityTestRule.getActivity().getWindow().getDecorView()))))
                .perform(click());
*/

    }


    @Test
    public void step3_verifyLogout() throws Exception {
        // Logging out the User
        onView(AppLocators.getNavigationDrawer())
                .check(matches(isDisplayed()))
                .perform(click());

        onView(AppLocators.getLogoutBtn())
                .check(matches(isDisplayed()))
                .perform(click());
    }
}
