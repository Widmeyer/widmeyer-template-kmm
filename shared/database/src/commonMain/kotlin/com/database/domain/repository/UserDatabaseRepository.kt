package com.database.domain.repository

import com.entity.model.User


interface UserDatabaseRepository {
    suspend fun getUser(): User?
    suspend fun insert(user: User)
    suspend fun clear()
}