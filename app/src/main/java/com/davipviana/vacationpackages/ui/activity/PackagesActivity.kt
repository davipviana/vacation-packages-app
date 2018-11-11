package com.davipviana.vacationpackages.ui.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import com.davipviana.vacationpackages.R
import com.davipviana.vacationpackages.dao.VacationPackageDao
import com.davipviana.vacationpackages.ui.adapter.PackageListAdapter

class PackagesActivity : AppCompatActivity() {

    companion object {
        const val APPBAR_TITLE = "Pacotes"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_packages)

        title = APPBAR_TITLE
        initializePackageList()
    }

    private fun initializePackageList() {
        val packagesList = findViewById<ListView>(R.id.packages_list)
        packagesList.adapter = PackageListAdapter(VacationPackageDao().getAll(), this)
    }
}
