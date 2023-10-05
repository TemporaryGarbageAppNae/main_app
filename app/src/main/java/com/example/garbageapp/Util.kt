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

        fun getJsonItemFromAssetAsArray(context: Context, fileName: String, itemName: String): List<String> {
            try {
                val jsonString = getJsonDataFromAsset(context, fileName)
                val jsonObject = JSONObject(jsonString)
                if (jsonObject.has(itemName)) {
                    val jsonArray = jsonObject.getJSONArray(itemName)
                    val itemList = mutableListOf<String>()

                    for (i in 0 until jsonArray.length()) {
                        itemList.add(jsonArray.getString(i))
                    }

                    return itemList
                } else {
                    Log.i(TAG, "Element $itemName not found in JSON $fileName")
                }
            } catch (e: Exception) {
                e.printStackTrace()
                Log.i(TAG, "Could not get element $itemName as an array in JSON $fileName", e)
            }
            return emptyList()
        }


        private const val TAG = "Util"
    }

}