package no.hvl.nameapp;

import android.content.Context;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.closeSoftKeyboard;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

/**
 * Created by Eier on 06.02.2018.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class TestLearningMode {


    @Rule
    public ActivityTestRule<LearningModeActivity> mActivityRule =
            new ActivityTestRule(LearningModeActivity.class);

    @Before
    public void setUp() {

    }

    @Test
    public void testOpensCorrectly() {
        (onView(withId(R.id.learning_mode_layout))).check(matches(isDisplayed()));
    }

    @Test
    public void testGuessWrong() {
        (onView(withId(R.id.editText_guess))).perform(typeText("WRONG_GUESS"));
        closeSoftKeyboard();
        (onView(withId(R.id.guess_button))).perform(click());
        onView(allOf(withId(R.id.textView_score), withText("0")))
                .check(matches(isDisplayed()));
    }

}
