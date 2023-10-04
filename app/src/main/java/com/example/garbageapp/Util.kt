package com.example.garbageapp

import android.content.Context
import android.util.Log
import org.json.JSONObject
import java.io.IOException

class Util {

    companion object json{
        fun getJsonDataFromAsset(context: Context, fileName: String): String {
            val jsonString: String
            try{
                jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
            } catch (e: IOException){
                e.printStackTrace()
                Log.i(TAG, "could not read json $fileName", e)
                return "null"
            }
            Log.i(TAG, "json $fileName succesfully read")
            return jsonString
        }

        fun getJsonItemFromAsset(context: Context, fileName: String, itemName: String): String {
            try{
                return JSONObject(getJsonDataFromAsset(context, fileName)).getString(itemName)
            }catch (e: IOException){
                e.printStackTrace()
                Log.i(TAG, "could not get element $itemName in json $fileName", e)
            }
            return "null"
        }

        fun getJsonItemFromAsset(jsonString: String, itemName: String): String {
            try{
                return JSONObject(jsonString).getString(itemName)
            }catch (e: IOException){
                e.printStackTrace()
                Log.i(TAG, "could not get element $itemName in json", e)
            }
            return "null"
        }

        private const val TAG = "Util"
    }

}