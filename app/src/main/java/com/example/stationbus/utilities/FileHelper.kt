package com.example.stationbus.utilities

import android.content.Context

class FileHelper {
    companion object{
        fun geTextFromResources(context :Context, resourceId: Int): String{
            return context.resources.openRawResource(resourceId).use {
                it.bufferedReader().use{
                    it.readText()
                }
            }
        }

        fun geTextFromAssets(context :Context, fileName :String): String{
            return context.assets.open(fileName).use {
                it.bufferedReader().use{
                    it.readText()
                }
            }
        }
    }
}