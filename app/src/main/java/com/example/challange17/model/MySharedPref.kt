package com.example.challange17.model

import android.content.Context
import com.example.challange17.ui.food.Food
import java.io.File

class MySharedPref(context: Context) {

    companion object {
        private const val FILE_KEY = "user_info"
        private const val File_SIZE = "file_size"
        private const val File_Food = "Food_items"
    }

    private val sharedPref = context.getSharedPreferences(FILE_KEY, Context.MODE_PRIVATE)


    fun savesize(size: Float){
        sharedPref.edit()
            .putFloat(File_SIZE, size)
            .apply()
    }

    fun getsize(): Float? {
        return sharedPref.getFloat(File_SIZE, 0f)
    }

    fun savpositin(pos: Int){
        sharedPref.edit()
            .putInt(File_Food, pos)
            .apply()
    }

    fun getpsition(): Int {
        return sharedPref.getInt(File_Food, 0)
    }

}