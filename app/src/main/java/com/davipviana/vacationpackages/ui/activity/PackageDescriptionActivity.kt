package com.davipviana.vacationpackages.ui.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.davipviana.vacationpackages.R
import com.davipviana.vacationpackages.extensions.toCurrencyString
import com.davipviana.vacationpackages.model.VacationPackage
import java.math.BigDecimal
import java.text.SimpleDateFormat
import java.util.*

class PackageDescriptionActivity : AppCompatActivity() {

    companion object {
        const val APPBAR_TITLE : String = "Resumo do pacote"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_package_description)

        title = APPBAR_TITLE

        val saoPauloVacationPackage = VacationPackage("São Paulo", "sao_paulo_sp",
            2, BigDecimal("243.99"))

        setLocalInfo(saoPauloVacationPackage)

        setImageInfo(saoPauloVacationPackage)

        setDaysInfo(saoPauloVacationPackage)

        setPriceInfo(saoPauloVacationPackage)

        setDateInfo(saoPauloVacationPackage)
    }

    private fun setDateInfo(vacationPackage: VacationPackage) {
        val txtDate = findViewById<TextView>(R.id.package_description_date)
        val departureDate = Calendar.getInstance()
        val arrivalDate = Calendar.getInstance()
        arrivalDate.add(Calendar.DATE, vacationPackage.days)
        val dateFormat = SimpleDateFormat("dd/MM")
        txtDate.text = dateFormat.format(departureDate.time) +
                " - " +
                dateFormat.format(arrivalDate.time) +
                " de " +
                arrivalDate.get(Calendar.YEAR)
    }

    private fun setPriceInfo(vacationPackage: VacationPackage) {
        val txtPrice = findViewById<TextView>(R.id.package_description_price)
        txtPrice.text = vacationPackage.price.toCurrencyString("pt", "br")
    }

    private fun setDaysInfo(vacationPackage: VacationPackage) {
        val txtDays = findViewById<TextView>(R.id.package_description_days)
        txtDays.text = vacationPackage.days.toString() +
                if (vacationPackage.days > 1)
                    " dias"
                else
                    " dia"
    }

    private fun setImageInfo(vacationPackage: VacationPackage) {
        val imgLocal = findViewById<ImageView>(R.id.package_description_image)
        val imageId = this.resources.getIdentifier(
            vacationPackage.image,
            "drawable",
            this.packageName
        )
        imgLocal.setImageDrawable(this.resources.getDrawable(imageId))
    }

    private fun setLocalInfo(vacationPackage: VacationPackage) {
        val txtLocal = findViewById<TextView>(R.id.package_description_local)
        txtLocal.text = vacationPackage.local
    }
}
