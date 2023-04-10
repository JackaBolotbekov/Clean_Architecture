package com.example.cleancodetest.domain.repository

import com.example.cleancodetest.domain.models.SaveUserNameParam
import com.example.cleancodetest.domain.models.UserName

interface UserRepository {

    fun saveName(saveParam: SaveUserNameParam): Boolean

    fun getName(): UserName
}