package no.hvl.nameapp;

import android.content.Context;
import android.preference.PreferenceManager;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.anything;
import static org.hamcrest.Matchers.allOf;

/**
 * Created by Torbjørn on 04.02.2018.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class TestGalleryActivity {

    @Rule
    public ActivityTestRule<SelectModeActivity> mActivityRule =
            new ActivityTestRule(SelectModeActivity.class);

    @Before
    public void setUp() {
        Context context = getInstrumentation().getTargetContext();
         PreferenceManager
                .getDefaultSharedPreferences(context)
                .edit()
                .putString("owner", "TestOwner")
                .commit();

    }

    @Test
    public void testNavigateUp() {
        onView(withId(R.id.button)).perform(click());
        onView(withContentDescription(R.string.abc_action_bar_up_description)).perform(click());
        onView(withId(R.id.select_mode_layout)).check(matches(isDisplayed()));
    }

    @Test
    public void testNavigateBack() {
        onView(withId(R.id.button)).perform(click());
        pressBack();
        onView(withId(R.id.select_mode_layout)).check(matches(isDisplayed()));
    }

    @Test
    public void testClickListItem() {
        onView(withId(R.id.button)).perform(click());
        onData(anything()).inAdapterView(withId(R.id.gridView))
                .atPosition(0)
                .perform(click());
        onView(withId(R.id.view_person_layout)).check(matches(isDisplayed()));
        onView(allOf(withId(R.id.profileName), withText("Per")))
                .check(matches(isDisplayed()));
        pressBack();
        onView(withId(R.id.gallery_layout)).check(matches(isDisplayed()));
    }

    @Test
    public void testClickAdd() {
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.pluss_button)).perform(click());
        onView(withId(R.id.add_person_layout)).check(matches(isDisplayed()));
    }
}