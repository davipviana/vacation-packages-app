package com.davipviana.vacationpackages.extensions

import java.math.BigDecimal
import java.text.DecimalFormat
import java.util.*

fun BigDecimal.toCurrencyString(language: String, country: String): String {
    return DecimalFormat
        .getCurrencyInstance(Locale(language, country))
        .format(this)
        .replace("R$", "R$ ")
}