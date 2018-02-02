package no.hvl.nameapp;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.anything;
import static org.hamcrest.Matchers.allOf;


/**
 * Created by Eier on 01.02.2018.
 */

@RunWith(AndroidJUnit4.class)
@LargeTest
public class TestListNamesActivity {


    @Rule
    public ActivityTestRule<ListNamesActivity> mActivityRule =
            new ActivityTestRule(ListNamesActivity.class);

    @Test
    public void navigatesBack() {

    }

    @Test
    public void clickListItem() {
        onData(anything()).inAdapterView(withId(R.id.list_view))
                .atPosition(0)
                .perform(click());
        onView(withId(R.id.profileName)).check(matches(isDisplayed()));
        onView(allOf(withId(R.id.profileName), withText("Per")))
                .check(matches(isDisplayed()));
    }
}
