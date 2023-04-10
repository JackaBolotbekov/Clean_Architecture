package com.example.cleancodetest.domain.usecase

import com.example.cleancodetest.domain.models.UserName
import com.example.cleancodetest.domain.repository.UserRepository

class GetUserNameUseCase(private val userRepository: UserRepository) {

    fun execute(): UserName {
        return userRepository.getName()
    }
}