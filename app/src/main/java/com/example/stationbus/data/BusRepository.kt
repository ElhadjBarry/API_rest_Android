package com.example.stationbus.data

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import androidx.annotation.WorkerThread
import androidx.lifecycle.MutableLiveData
import com.example.stationbus.LOG_TAG
import com.example.stationbus.WEB_SERVICE_URL
import com.example.stationbus.utilities.FileHelper
import com.squareup.moshi.Types
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class BusRepository (val app: Application){
    val busData = MutableLiveData<List<Bus>>()
    private val lisType = Types.newParameterizedType(
        List::class.java, Bus::class.java
    )

    init{
        //val text =FileHelper.geTextFromResources(app, R.raw.dataBus)
        CoroutineScope(Dispatchers.IO).launch {
            callWebService()
        }



    }
    @WorkerThread
    suspend fun callWebService () {
        if (networkAvailable()){
            val retrofit = Retrofit.Builder()
                .baseUrl(WEB_SERVICE_URL)
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
            val service = retrofit.create(BusService::class.java)
            val serviceData = service.getBusData().body() ?: emptyList()
            busData.postValue(serviceData)
        }

    }



    private fun networkAvailable(): Boolean {
         val connectivityManager = app.getSystemService(Context.CONNECTIVITY_SERVICE )
                as ConnectivityManager
         val networkInfo = connectivityManager.activeNetworkInfo
         return networkInfo?.isConnectedOrConnecting ?: false
     }
}