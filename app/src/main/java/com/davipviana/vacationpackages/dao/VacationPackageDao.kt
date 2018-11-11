package com.davipviana.vacationpackages.dao

import com.davipviana.vacationpackages.model.VacationPackage
import java.math.BigDecimal
import java.util.*


class VacationPackageDao {
    fun getAll(): List<VacationPackage> {
        return ArrayList(
            Arrays.asList(
                VacationPackage("São Paulo", "sao_paulo_sp", 2, BigDecimal(243.99)),
                VacationPackage("Belo Horizonte", "belo_horizonte_mg", 3, BigDecimal(421.50)),
                VacationPackage("Recife", "recife_pe", 4, BigDecimal(754.20)),
                VacationPackage("Rio de Janeiro", "rio_de_janeiro_rj", 6, BigDecimal(532.55)),
                VacationPackage("Salvador", "salvador_ba", 5, BigDecimal(899.99)),
                VacationPackage("Foz do Iguaçu", "foz_do_iguacu_pr", 1, BigDecimal(289.90))
            )
        )
    }

}