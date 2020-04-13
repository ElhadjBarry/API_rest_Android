package com.example.stationbus.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.example.stationbus.LOG_TAG
import com.example.stationbus.R
import com.example.stationbus.data.BusRepository
import com.example.stationbus.utilities.FileHelper
import com.squareup.moshi.Types

class MainViewModel (app: Application): AndroidViewModel(app) {

    private val dataRepo = BusRepository(app)
    val busData = dataRepo.busData





}