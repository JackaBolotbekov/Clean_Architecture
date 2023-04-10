package com.example.cleancodetest.data.storage.sharedprefs

import android.content.Context
import com.example.cleancodetest.data.KEY_NAME
import com.example.cleancodetest.data.KEY_SURNAME
import com.example.cleancodetest.data.SHARED_PREFS_NAME
import com.example.cleancodetest.data.storage.UserStorage
import com.example.cleancodetest.data.storage.models.User

class SharedPrefUserStorage(context: Context) : UserStorage {

    private val sharedPreferences = context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)

    override fun save(user: User): Boolean {
        sharedPreferences.edit().putString(KEY_NAME, user.name).apply()
        sharedPreferences.edit().putString(KEY_SURNAME, user.surname).apply()
        return true
    }

    override fun get(): User {
        val name = sharedPreferences.getString(KEY_NAME, "b") ?: "B"
        val surname = sharedPreferences.getString(KEY_SURNAME, "n") ?: "N"
        return User (name = name, surname = surname)
    }
}