package com.example.ad340jeremywardweeklyassignments;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityScenarioRule<MainActivity> mainActivityRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void canGoThroughForm() {
        onView(withId(R.id.nameField)).perform(replaceText("Jeremy Ward"));
        onView(withId(R.id.emailField)).perform(replaceText("foo@bar.com"));
        onView(withId(R.id.usernameField)).perform(replaceText("jward"));
        onView(withId(R.id.occupationField)).perform(replaceText("Software Engineer"));
        onView(withId(R.id.locationField)).perform((replaceText("Seattle")));
        onView(withId(R.id.descriptionField)).perform(replaceText("This is a description text"));

        //onView(withId(R.id.dobButton)).perform(click());

        //onView(withClassName(Matchers.equalTo(DatePicker.class.getName())))
//                .perform(PickerActions.setDate(2000, 2 + 1, 5));

        onView(withId(R.id.goToAnotherActivity)).perform(click());


        onView(withId(R.id.nameView))
                .check(matches(withText("Jeremy Ward")));
    }
    }