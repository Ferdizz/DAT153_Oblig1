package no.hvl.nameapp;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;


/**
 * Created by Eier on 30.01.2018.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class TestSelectModeActivity {

    @Rule
    public ActivityTestRule<SelectModeActivity> mActivityRule =
            new ActivityTestRule(SelectModeActivity.class);

    @Test
    public void testNavigateToList() {
        onView(withId(R.id.button2)).perform(click());
        onView(withId(R.id.list_names_layout)).check(matches(isDisplayed()));
    }
    @Test
    public void testNavigateToGallery() {
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.gallery_layout)).check(matches(isDisplayed()));
    }
    @Test
    public void testNavigateToLearningMode() {
        onView(withId(R.id.button3)).perform(click());
        onView(withId(R.id.learning_mode_layout)).check(matches(isDisplayed()));

    }
    @Test
    public void testNavigateToAddPerson() {
        onView(withId(R.id.selectImgBtn)).perform(click());
        onView(withId(R.id.add_person_layout)).check(matches(isDisplayed()));
    }
}
