package org.itstep.liannoi.skol.presentation

import android.content.SharedPreferences
import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import org.itstep.liannoi.skol.R
import org.itstep.liannoi.skol.application.ApplicationDefaults
import org.itstep.liannoi.skol.application.common.colors.Colorize

class SettingsFragment constructor(
    private val colorClient: Colorize
) : PreferenceFragmentCompat(),
    SharedPreferences.OnSharedPreferenceChangeListener {

    private val sharedPreferences: SharedPreferences
        get() = preferenceManager.sharedPreferences

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.preferences, rootKey)
    }

    override fun onSharedPreferenceChanged(preferences: SharedPreferences, rootKey: String) {
        refreshBackground(preferences)
    }

    override fun onStart() {
        super.onStart()
        refreshBackground(sharedPreferences)
    }

    override fun onResume() {
        super.onResume()
        sharedPreferences.registerOnSharedPreferenceChangeListener(this)
    }

    override fun onPause() {
        super.onPause()
        sharedPreferences.unregisterOnSharedPreferenceChangeListener(this)
    }

    ///////////////////////////////////////////////////////////////////////////
    // Helpers
    ///////////////////////////////////////////////////////////////////////////

    private fun readColors(preferences: SharedPreferences) {
        colorClient.red(preferences.getInt(ApplicationDefaults.COLOR_RED, 0))
        colorClient.green(preferences.getInt(ApplicationDefaults.COLOR_GREEN, 0))
        colorClient.blue(preferences.getInt(ApplicationDefaults.COLOR_BLUE, 0))
    }

    private fun refreshBackground(preferences: SharedPreferences) {
        readColors(preferences)
        view?.setBackgroundColor(colorClient.determine().toArgb())
    }
}
