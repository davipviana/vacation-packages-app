package com.davipviana.vacationpackages.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.davipviana.vacationpackages.R
import com.davipviana.vacationpackages.model.VacationPackage
import com.davipviana.vacationpackages.extensions.*
import java.text.DecimalFormat
import java.util.*

class PackageListAdapter(
    private val packageList: List<VacationPackage>,
    private val context: Context
) : BaseAdapter() {

    override fun getCount(): Int {
        return packageList.size
    }

    override fun getItem(position: Int): VacationPackage {
        return packageList[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = LayoutInflater.from(context).inflate(R.layout.package_item, parent, false)
        val vacationPackage = packageList[position]

        setLocalInfo(view, vacationPackage)
        setImageInfo(view, vacationPackage)
        setDaysInfo(view, vacationPackage)
        setPriceInfo(view, vacationPackage)

        return view
    }

    private fun setPriceInfo(view: View, vacationPackage: VacationPackage) {
        val txtPrice = view.findViewById<TextView>(R.id.package_item_price)

        txtPrice.text = vacationPackage.price.toCurrencyString("pt", "br")
    }

    private fun setDaysInfo(view: View, vacationPackage: VacationPackage) {
        val txtDays = view.findViewById<TextView>(R.id.package_item_days)
        txtDays.text = vacationPackage.days.toString() +
                if (vacationPackage.days > 1)
                    " dias"
                else
                    " dia"
    }

    private fun setImageInfo(view: View, vacationPackage: VacationPackage) {
        val imgLocal = view.findViewById<ImageView>(R.id.package_item_image)
        val imageId = context.resources.getIdentifier(
            vacationPackage.image,
            "drawable",
            context.packageName
        )
        imgLocal.setImageDrawable(context.resources.getDrawable(imageId))
    }

    private fun setLocalInfo(view: View, vacationPackage: VacationPackage) {
        val txtLocal = view.findViewById<TextView>(R.id.package_item_local)
        txtLocal.text = vacationPackage.local
    }
}
