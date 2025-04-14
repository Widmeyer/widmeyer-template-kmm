package com.widmeyertemplate.network.data.utils

import com.widmeyertemplate.network.domain.model.CustomResponseException
import dev.icerock.moko.network.exceptionfactory.HttpExceptionFactory
import dev.icerock.moko.network.exceptions.ResponseException
import io.ktor.client.request.HttpRequest
import io.ktor.client.statement.HttpResponse
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive

class CustomExceptionParser(private val json: Json) : HttpExceptionFactory.HttpExceptionParser {

    @Suppress("NestedBlockDepth")
    override fun parseException(
        request: HttpRequest,
        response: HttpResponse,
        responseBody: String?,
    ): ResponseException? {
        @Suppress("TooGenericExceptionCaught", "SwallowedException")
        return try {
            val body = responseBody.orEmpty()
            val jsonObject = json.parseToJsonElement(body).jsonObject
            val responseTitle = jsonObject[ERROR_TITLE]?.jsonPrimitive?.content.orEmpty()
            val responseMessage = jsonObject[ERROR_MESSAGE]?.jsonPrimitive?.content.orEmpty()
            val responseStatus: Int = response.status.value

            CustomResponseException(
                request = request,
                response = response,
                responseTitle = responseTitle,
                responseMessage = responseMessage,
                responseStatus = responseStatus
            )
        } catch (exception: Exception) {
            null
        }
    }

    companion object {
        private const val ERROR_TITLE = "title"
        private const val ERROR_MESSAGE = "description"
    }
}
