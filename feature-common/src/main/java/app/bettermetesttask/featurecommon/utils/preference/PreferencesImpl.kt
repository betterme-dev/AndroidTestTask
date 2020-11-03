package app.bettermetesttask.featurecommon.utils.preference

import android.content.SharedPreferences
import androidx.core.content.edit
import app.bettermetesttask.domaincore.utils.preferences.Preferences
import app.bettermetesttask.domaincore.utils.preferences.Preferences.Companion.KEY_FIRST_LAUNCH
import javax.inject.Inject

class PreferencesImpl @Inject constructor(
    private val sharedPreferences: SharedPreferences
) : Preferences {

    override fun isFirstLaunch(): Boolean {
        return sharedPreferences.getBoolean(KEY_FIRST_LAUNCH, true)
    }

    override fun markAlreadyLaunched() {
        sharedPreferences.edit { putBoolean(KEY_FIRST_LAUNCH, false) }
    }
}