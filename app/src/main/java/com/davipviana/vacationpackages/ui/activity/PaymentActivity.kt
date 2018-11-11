package com.davipviana.vacationpackages.ui.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.davipviana.vacationpackages.R
import com.davipviana.vacationpackages.extensions.toCurrencyString
import com.davipviana.vacationpackages.model.VacationPackage
import java.math.BigDecimal

class PaymentActivity : AppCompatActivity() {

    companion object {
        const val APPBAR_TITLE = "Pagamento"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)

        title = APPBAR_TITLE

        val saoPauloVacationPackage = VacationPackage("São Paulo", "sao_paulo_sp",
            2, BigDecimal("243.99")
        )

        setPriceInfo(saoPauloVacationPackage)

        val intent = Intent(this, PurchaseSummaryActivity::class.java)
        startActivity(intent)
    }

    private fun setPriceInfo(vacationPackage: VacationPackage) {
        val txtPrice = findViewById<TextView>(R.id.payment_price)
        txtPrice.text = vacationPackage.price.toCurrencyString("pt", "br")
    }
}
