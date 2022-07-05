package com.example.espressocomposebug

import android.util.Log
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @get : Rule
    var mActivityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun test() {
        Log.d("TRLOG", "TRLOG *** BEFORE OUTSIDE CLICK")
        Espresso.onView(withId(R.id.button_outside)).perform(ViewActions.click())
        Log.d("TRLOG", "TRLOG *** AFTER OUTSIDE CLICK")

        Log.d("TRLOG", "TRLOG *** BEFORE INSIDE CLICK")
        Espresso.onView(withId(R.id.button_inside)).perform(ViewActions.click())
        Log.d("TRLOG", "TRLOG *** AFTER INSIDE CLICK")
        Thread.sleep(250000000)
    }

}
