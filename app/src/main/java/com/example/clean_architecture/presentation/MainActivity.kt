package com.example.clean_architecture.presentation

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.clean_architecture.R
import com.example.cleancodetest.data.repository.UserRepositoryImpl
import com.example.cleancodetest.data.storage.sharedprefs.SharedPrefUserStorage
import com.example.cleancodetest.domain.models.SaveUserNameParam
import com.example.cleancodetest.domain.models.UserName
import com.example.cleancodetest.domain.usecase.GetUserNameUseCase
import com.example.cleancodetest.domain.usecase.SaveUserNameUseCase

class MainActivity : AppCompatActivity() {

    private val userRepository by lazy(LazyThreadSafetyMode.NONE) {
        UserRepositoryImpl(userStorage = SharedPrefUserStorage(context = applicationContext))
    }

    private val getUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) {
        GetUserNameUseCase(userRepository)
    }

    private val saveUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) {
        SaveUserNameUseCase(userRepository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val tvData = findViewById<TextView>(R.id.tv_data)
        val btnGetData = findViewById<Button>(R.id.btn_get_data)
        val etPutData = findViewById<EditText>(R.id.et_put_data)
        val btnSaveData = findViewById<Button>(R.id.btn_save_data)

        btnGetData.setOnClickListener {
            val text = etPutData.text.toString()
            val params = SaveUserNameParam(name = text)
            val result: Boolean = saveUserNameUseCase.execute(params = params)
            tvData.text = "Save Result = $result"
        }

        btnSaveData.setOnClickListener {
            val userName: UserName = getUserNameUseCase.execute()
            val result: String = "${userName.name} ${userName.surname}"
            tvData.text = result
        }
    }
}