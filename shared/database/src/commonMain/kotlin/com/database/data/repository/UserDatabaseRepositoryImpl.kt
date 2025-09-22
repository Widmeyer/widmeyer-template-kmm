package com.database.data.repository

import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToOneOrNull
import com.database.AppDatabase
import com.database.domain.mapper.toDomain
import com.database.domain.repository.UserDatabaseRepository
import com.entity.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

internal class UserDatabaseRepositoryImpl(private val appDatabase: AppDatabase) :
    UserDatabaseRepository {
    private val queries = appDatabase.userQueries
    override suspend fun getUser(): User? = withContext(Dispatchers.IO) {
        queries
            .select()
            .asFlow()
            .mapToOneOrNull(Dispatchers.IO)
            .map { it?.toDomain() }
            .firstOrNull()
    }


    override suspend fun insert(user: User) = withContext(Dispatchers.IO) {
        queries.transaction {
            queries.clear()
            queries.insert(
                id = user.id,
                name = user.name,
                username = user.username,
                phonenumber = user.phoneNumber,
                birthday = user.birthday
            )
        }
    }

    override suspend fun clear() = withContext(Dispatchers.IO) {
        queries.clear()
    }
}