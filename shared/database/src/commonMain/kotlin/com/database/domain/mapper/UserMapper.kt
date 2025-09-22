package com.database.domain.mapper

import com.entity.model.User
import com.database.User as UserDto

fun UserDto.toDomain() = User(
    id = id,
    name = name,
    username = username,
    phoneNumber = phonenumber,
    birthday = birthday
)

fun User.toDto() = UserDto(
    id = id,
    name = name,
    username = username,
    phonenumber = phoneNumber,
    birthday = birthday
)