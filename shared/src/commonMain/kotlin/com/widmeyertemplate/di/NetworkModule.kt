package com.widmeyertemplate.di

import com.widmeyertemplate.data.infrastructure.KeyValueStorage
import com.widmeyertemplate.data.infrastructure.NativeHost
import com.widmeyertemplate.data.utils.CustomExceptionParser
import com.widmeyertemplate.data.utils.Log
import com.widmeyertemplate.entity.DeadTokenException
import dev.icerock.moko.network.createHttpClientEngine
import dev.icerock.moko.network.exceptionfactory.HttpExceptionFactory
import dev.icerock.moko.network.exceptionfactory.parser.ValidationExceptionParser
import dev.icerock.moko.network.nullable.Nullable
import dev.icerock.moko.network.plugins.ExceptionPlugin
import dev.icerock.moko.network.plugins.RefreshTokenPlugin
import dev.icerock.moko.network.plugins.TokenPlugin
import io.ktor.client.HttpClient
import io.ktor.http.HttpStatusCode
import kotlinx.serialization.json.Json
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.core.qualifier.named
import org.koin.dsl.module
import org.koin.mp.KoinPlatform


@Suppress("LongMethod")
val networkModule: Module = module {
    val baseUrl: String = NativeHost.getUrl()

    single<Json> {
        Json {
            ignoreUnknownKeys = true
        }
    }

   // singleOf(::createHttpClient)

    // Authentication (NOT JWt TOKEN)
    /*factory<AuthenticationApi> {
        AuthenticationApi(
            basePath = baseUrl,
            httpClient = createHttpClient(
                json = get(),
                authenticationApi = null
            ),
            json = get()
        )
    }*/
    // WITH JWT TOKEN
 /*   single<TestApi> {
        TestApi(
            basePath = baseUrl,
            httpClient = get(),
            json = get()
        )
    }*/

}

/*
private fun createHttpClient(
    json: Json,
    authenticationApi: AuthenticationApi?,
): HttpClient {
    val keyValueStorage: KeyValueStorage = KoinPlatform.getKoin().get()
    Log("ACCESS TOKEN", keyValueStorage.accessToken.toString())
    Log("REFRESH TOKEN", keyValueStorage.refreshToken.toString())

    return HttpClient(createHttpClientEngine()) {
        install(ExceptionPlugin) {
            exceptionFactory = HttpExceptionFactory(
                defaultParser = CustomExceptionParser(json),
                customParsers = mapOf(
                    HttpStatusCode.UnprocessableEntity.value to ValidationExceptionParser(json)
                )
            )
        }

        expectSuccess = false

        if (authenticationApi != null) {
            install(RefreshTokenPlugin) {
                isCredentialsActual = { request ->
                    request.headers["Authorization"] == keyValueStorage.accessToken?.let { "Bearer $it" }
                }
                updateTokenHandler = {
                    try {
                        val response = authenticationApi.apiV1EmployeeTokensRefreshPostResponse(
                            tokenRefreshRequest = TokenRefreshRequest(
                                accessToken = keyValueStorage.accessToken.let { "" },
                                refreshToken = keyValueStorage.refreshToken.let { "" },
                            )
                        )

                        val body = response.body()
                        keyValueStorage.accessToken = body.accessToken
                        keyValueStorage.refreshToken = body.refreshToken

                        response.httpResponse.status == HttpStatusCode.OK
                    } catch (e: CustomResponseException) {
                        e.printStackTrace()

                        keyValueStorage.accessToken = null
                        keyValueStorage.refreshToken = null

                        throw DeadTokenException(
                            message = e.message ?: "",
                            cause = e
                        )
                    } catch (exc: Exception) {
                        exc.printStackTrace()

                        keyValueStorage.accessToken = null
                        keyValueStorage.refreshToken = null

                        throw DeadTokenException(
                            message = exc.message ?: "",
                            cause = exc
                        )
                    }
                }
            }
            install(TokenPlugin) {
                tokenHeaderName = "Authorization"
                tokenProvider = TokenPlugin.TokenProvider {
                    keyValueStorage.accessToken?.let { "Bearer $it" }
                }
            }
        }
    }
}*/
