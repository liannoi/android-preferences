package org.itstep.liannoi.skol.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.itstep.liannoi.skol.R
import org.itstep.liannoi.skol.application.storage.colors.ColorClient

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupSettingsFragment()
    }

    ///////////////////////////////////////////////////////////////////////////
    // Helpers
    ///////////////////////////////////////////////////////////////////////////

    private fun setupSettingsFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.settings_frame, SettingsFragment(ColorClient()))
            .commit()
    }
}
