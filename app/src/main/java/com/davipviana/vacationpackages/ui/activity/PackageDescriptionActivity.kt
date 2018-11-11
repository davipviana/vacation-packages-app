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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_package_description)

        title = "Resumo do pacote"

        val saoPauloVacationPackage = VacationPackage("São Paulo", "sao_paulo_sp",
            2, BigDecimal("243.99"))

        val txtLocal = findViewById<TextView>(R.id.package_description_local)
        txtLocal.text = saoPauloVacationPackage.local

        val imgLocal = findViewById<ImageView>(R.id.package_description_image)
        val imageId = this.resources.getIdentifier(
            saoPauloVacationPackage.image,
            "drawable",
            this.packageName
        )
        imgLocal.setImageDrawable(this.resources.getDrawable(imageId))

        val txtDays = findViewById<TextView>(R.id.package_description_days)
        txtDays.text = saoPauloVacationPackage.days.toString() +
                if (saoPauloVacationPackage.days > 1)
                    " dias"
                else
                    " dia"

        val txtPrice = findViewById<TextView>(R.id.package_description_price)
        txtPrice.text = saoPauloVacationPackage.price.toCurrencyString("pt", "br")

        val txtDate = findViewById<TextView>(R.id.package_description_date)
        val departureDate = Calendar.getInstance()
        val arrivalDate = Calendar.getInstance()
        arrivalDate.add(Calendar.DATE, saoPauloVacationPackage.days)
        val dateFormat = SimpleDateFormat("dd/MM")
        txtDate.text = dateFormat.format(departureDate.time) +
                        " - " +
                        dateFormat.format(arrivalDate.time) +
                        " de " +
                        arrivalDate.get(Calendar.YEAR)
    }
}
