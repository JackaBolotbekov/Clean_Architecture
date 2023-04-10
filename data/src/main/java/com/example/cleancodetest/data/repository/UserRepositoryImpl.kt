package com.example.cleancodetest.data.repository

import com.example.cleancodetest.data.storage.UserStorage
import com.example.cleancodetest.data.storage.models.User
import com.example.cleancodetest.domain.models.SaveUserNameParam
import com.example.cleancodetest.domain.models.UserName
import com.example.cleancodetest.domain.repository.UserRepository


class UserRepositoryImpl(private val userStorage: UserStorage) : UserRepository {

    override fun saveName(saveParam: SaveUserNameParam): Boolean {
        val user = mapToStorage(saveParam)
        return userStorage.save(user)
    }

    override fun getName(): UserName {
        val user = userStorage.get()
        return mapToDomain(user)
    }

    private fun mapToStorage(saveParam: SaveUserNameParam): User {
        return User(name = saveParam.name, surname = " ")
    }

    private fun mapToDomain(user: User) : UserName {
        return UserName(name = user.name, surname = user.surname)
    }
}