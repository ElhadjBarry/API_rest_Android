package com.example.stationbus.ui.main


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewOutlineProvider
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.stationbus.R
import java.lang.StringBuilder
import java.util.stream.Collector.of
import java.util.stream.DoubleStream.of


class MainFragment: Fragment() {

    private  lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater:LayoutInflater, contener: ViewGroup?,
        SavedInstanceState: Bundle?
    ): View {
       // viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        viewModel.busData.observe(this, Observer {
            val busCity = StringBuilder()

        })
        return inflater.inflate(R.layout.main_fragment, contener,  false)
    }


}