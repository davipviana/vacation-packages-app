package com.davipviana.vacationpackages.model

import java.io.Serializable
import java.math.BigDecimal

class VacationPackage(val local: String, val image: String, val days: Int, val price: BigDecimal) : Serializable

