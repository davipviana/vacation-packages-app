package com.davipviana.vacationpackages.ui.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
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

        if(intent.hasExtra("package")) {
            val vacationPackage = intent.getSerializableExtra("package") as VacationPackage

            setPriceInfo(vacationPackage)

            initializePaymentEndButton(vacationPackage)
        }

    }

    private fun initializePaymentEndButton(vacationPackage: VacationPackage) {
        val paymentEndButton = findViewById<Button>(R.id.payment_end_button)
        paymentEndButton.setOnClickListener {
            val intent = Intent(this, PurchaseSummaryActivity::class.java)
            intent.putExtra("package", vacationPackage)
            startActivity(intent)
        }
    }

    private fun setPriceInfo(vacationPackage: VacationPackage) {
        val txtPrice = findViewById<TextView>(R.id.payment_price)
        txtPrice.text = vacationPackage.price.toCurrencyString("pt", "br")
    }
}
