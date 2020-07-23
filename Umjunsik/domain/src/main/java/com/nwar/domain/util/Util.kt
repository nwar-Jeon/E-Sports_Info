package com.nwar.domain.util

fun Double.roundDouble(decimalDigit : Int) : Double = String.format("%.${decimalDigit}f", this).toDouble()