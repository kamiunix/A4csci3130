package com.acme.a3csci3130;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.assertEquals;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class dbInstrumentedTest {

    public String name, number, province, address, primary;
    public Business business;


    @Rule
    public ActivityTestRule<MainActivity> mainActRule = new ActivityTestRule<>(MainActivity.class);

    /**
     * initializer of business object
     */
    @Before
    public void init() {
        System.out.print("Running tests on db");

        name = "Metal";
        number = "111444888";
        province = "NS";
        address = "123 black lane";
        primary = "Distributor";

        business = new Business(null, name, number, province, address, primary);
    }

    /**
     * test for db create
     * @throws Exception
     */
    @Test
    public void useAppContext() throws Exception {
        onView(withId(R.id.submitButton)).perform(click());
        onView(withId(R.id.name)).perform(typeText(name));
        onView(withId(R.id.number)).perform(typeText(number));
        onView(withId(R.id.province)).perform(typeText(province));
        onView(withId(R.id.address)).perform(typeText(address));
        onView(withId(R.id.primary)).perform(typeText(primary));
        onView(withId(R.id.submitButton)).perform(click());
        onView(withId(R.id.listView)).perform(click());
    }

    /**
     * test for db update
     * @throws Exception
     */
    @Test
    public void updateTest() throws Exception {
        onView(withId(R.id.listView)).perform(click());
        onView(withId(R.id.name)).perform(typeText(name));
        onView(withId(R.id.updateButton)).perform(click());
    }

    /**
     * test for db erase
     * @throws Exception
     */
    @Test
    public void deleteTest() throws Exception {
        onView(withId(R.id.listView)).perform(click());
        onView(withId(R.id.deleteButton)).perform(click());
    }
}
