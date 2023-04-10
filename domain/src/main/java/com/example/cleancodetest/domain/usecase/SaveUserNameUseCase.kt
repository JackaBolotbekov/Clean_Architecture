package com.example.cleancodetest.domain.usecase

import com.example.cleancodetest.domain.models.SaveUserNameParam
import com.example.cleancodetest.domain.models.UserName
import com.example.cleancodetest.domain.repository.UserRepository

class SaveUserNameUseCase(private val userRepository: UserRepository) {

    fun execute(params: SaveUserNameParam): Boolean {
        val result: Boolean = userRepository.saveName(saveParam = params)
        return result
    }
}