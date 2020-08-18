package org.itstep.liannoi.skol.application.common.colors

import android.graphics.Color

interface Colorize {

    fun determine(): Color

    fun red(value: Int)

    fun green(value: Int)

    fun blue(value: Int)
}
