package org.itstep.liannoi.skol.application.storage.colors

import android.graphics.Color
import org.itstep.liannoi.skol.application.common.colors.ColorDetails
import org.itstep.liannoi.skol.application.common.colors.Colorize

class ColorClient : Colorize {

    private var details: ColorDetails = ColorDetails()

    override fun red(value: Int) {
        details.red = value
    }

    override fun green(value: Int) {
        details.green = value
    }

    override fun blue(value: Int) {
        details.blue = value
    }

    override fun determine(): Color =
        Color.valueOf(Color.rgb(details.red, details.green, details.blue))
}
