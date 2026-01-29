package com.danvhae.oscar.console.badapple.utils

object BrailleUtil {
    fun Int.toBraille(): Char{
        return (0x2800 + this).toChar()
    }
}