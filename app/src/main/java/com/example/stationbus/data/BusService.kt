package com.example.stationbus.data

import retrofit2.http.GET
import retrofit2.Response

interface BusService {
    @GET(" /bus/nearstation/latlon/ 41.3985182/2.1917991/1.json")
    suspend fun getBusData(): Response<List<Bus>>
}