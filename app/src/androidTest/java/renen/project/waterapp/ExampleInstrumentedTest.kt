package renen.project.waterapp

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
@LargeTest
class ExampleInstrumentedTest {

    @get:Rule
    var activityRule: ActivityTestRule<MainActivity>
            = ActivityTestRule(MainActivity::class.java)

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("renen.project.waterapp", appContext.packageName)
    }

    @Test
    fun graph_test(){
        onView(withId(R.id.slimChart))            // withId(R.id.my_view) is a ViewMatcher
            .perform(click())               // click() is a ViewAction
            .check(matches(isDisplayed()))
        Thread.sleep(1000)
    }
    @Test
    fun history_test(){
        onView(withId(R.id.btnHistory))            // withId(R.id.my_view) is a ViewMatcher
            .perform(click())               // click() is a ViewAction
        Thread.sleep(1000)
    }
    @Test
    fun settings_test(){
        onView(withId(R.id.btnSettings))            // withId(R.id.my_view) is a ViewMatcher
            .perform(click())               // click() is a ViewAction
        Thread.sleep(1000)
    }
}