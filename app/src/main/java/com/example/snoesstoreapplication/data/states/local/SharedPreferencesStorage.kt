package com.example.snoesstoreapplication.data.states.local

import android.content.Context

open class SharedPreferencesStorage(context: Context) {
    private val prefs = context.getSharedPreferences("APP_PREFS", Context.MODE_PRIVATE)
    var lastPage: Int
        get() = prefs.getInt("lastVisit", 1)
        set(value) = prefs.edit().putInt("lastVisit", value).apply()

}