package no.hvl.nameapp;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


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
    public void listGoesOverTheFold() {

    }
}
