package no.hvl.nameapp;

import android.content.Context;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by Eier on 06.02.2018.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class TestPreferences {

    @Rule
    public ActivityTestRule<SelectModeActivity> mActivityRule =
            new ActivityTestRule(SelectModeActivity.class);

    @Before
    public void setUp() {
        Context context = getInstrumentation().getTargetContext();
        PreferenceManager
                .getDefaultSharedPreferences(context)
                .edit()
                .clear();
    }

    @Test
    public void testNoPreferencesSet() {
      //  onView(withId(R.id.add_person_layout)).check(matches(isDisplayed()));
    }
}