package uk.co.imagitech.robolectricdialogfragmentissue

import androidx.fragment.app.testing.launchFragment
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.RootMatchers
import androidx.test.espresso.matcher.RootMatchers.isDialog
import androidx.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.LooperMode


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
@LooperMode(LooperMode.Mode.PAUSED)
class MyDialogFragmentTest {

    @Test
    fun dialogFragment_hasOkButton() {
        launchFragment<MyDialogFragment>().apply {
            onFragment { fragment ->
                assertThat(fragment.dialog).isNotNull()
                assertThat(fragment.requireDialog().isShowing).isTrue()
            }
        }
        onView(withText("OK")).inRoot(isDialog()).check(matches(isCompletelyDisplayed()))
    }
}
