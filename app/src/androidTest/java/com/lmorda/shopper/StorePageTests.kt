package com.lmorda.shopper

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class StorePageTests {

    @Test
    fun testStorePageLaunchesAfterSplash() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.storeTitle)).check(matches(withText("Jons")))
        activityScenario.close()
    }
}