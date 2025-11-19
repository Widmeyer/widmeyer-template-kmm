package com.network.di

import com.core.data.utils.NativeHost
import com.network.data.utils.CustomExceptionParser
import dev.icerock.moko.network.createHttpClientEngine
import dev.icerock.moko.network.exceptionfactory.HttpExceptionFactory
import dev.icerock.moko.network.exceptionfactory.parser.ValidationExceptionParser
import dev.icerock.moko.network.plugins.ExceptionPlugin
import io.ktor.client.HttpClient
import io.ktor.client.plugins.logging.DEFAULT
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.http.HttpStatusCode
import kotlinx.serialization.json.Json
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import org.koin.mp.KoinPlatform.getKoin

val networkModule: Module = module {
    val baseUrl: String by lazy { getKoin().get<NativeHost>().getUrl() }

    single<Json> { Json { ignoreUnknownKeys = true } }
    singleOf(::createHttpClient)

    /* single<ApplicationInfoApi> {
         ApplicationInfoApi(
             basePath = baseUrl,
             httpClient = get(),
             json = get()
         )
     }
     single<AuthorizationApi> {
         AuthorizationApi(
             basePath = baseUrl,
             httpClient = createHttpClient(
                 json = get(),
                 authorizationApi = null
             ),
             json = get()
         )
     }*/
    // OR

    /*
    single<SupabaseClient> {
        val url: String by lazy { getKoin().get<NativeHost>().getUrl() }
        val key: String by lazy { getKoin().get<NativeHost>().getKey() }

        createSupabaseClient(
            supabaseUrl = url,
            supabaseKey = key
        ) {
            install(Postgrest) {
                defaultSchema = "public"
                propertyConversionMethod = PropertyConversionMethod.CAMEL_CASE_TO_SNAKE_CASE
            }
            install(Auth) {
                alwaysAutoRefresh = true
                enableLifecycleCallbacks = true
            }
        }
    }
     */
}

private fun createHttpClient(json: Json): HttpClient = HttpClient(createHttpClientEngine()) {
    install(Logging) {
        level = LogLevel.ALL
        logger = Logger.DEFAULT
    }
    install(ExceptionPlugin) {
        exceptionFactory = HttpExceptionFactory(
            defaultParser = CustomExceptionParser(json),
            customParsers = mapOf(
                HttpStatusCode.UnprocessableEntity.value to ValidationExceptionParser(json)
            )
        )
    }
    expectSuccess = false
}

/*private fun createHttpClient(
    json: Json,
    authorizationApi: UserApi?, // TODO: AuthorizationApi
): HttpClient {
    val keyValueStorage: KeyValueStorage = getKoin().get()
    val nativeHost: NativeHost = getKoin().get()
    return HttpClient(createHttpClientEngine()) {

        install(Logging) {
            level = LogLevel.ALL
            logger = Logger.DEFAULT
        }

        install(ExceptionPlugin) {
            exceptionFactory = HttpExceptionFactory(
                defaultParser = CustomExceptionParser(json),
                customParsers = mapOf(
                    HttpStatusCode.UnprocessableEntity.value to ValidationExceptionParser(json)
                )
            )
        }

        expectSuccess = false

        if (authorizationApi != null) {
            install(RefreshTokenPlugin) {
                isCredentialsActual = { request ->
                    request.headers["Authorization"] == keyValueStorage.accessToken?.let { "Bearer $it" }
                }
                updateTokenHandler = {
                    try {
                        *//* val response = authorizationApi.apiAuthRefreshPostResponse(
                             userRefreshTokenPairBody = UserRefreshTokenPairBody(
                                 accessToken = keyValueStorage.accessToken,
                                 refreshToken = keyValueStorage.refreshToken,
                             )
                         )

                         val body = response.body()
                         keyValueStorage.accessToken = body.accessToken
                         keyValueStorage.refreshToken = body.refreshToken

                         response.httpResponse.status == HttpStatusCode.OK*//*
                        true
                    } catch (e: CustomResponseException) {
                        e.printStackTrace()

                        keyValueStorage.accessToken = null
                        keyValueStorage.refreshToken = null

                        throw DeadTokenException(
                            message = e.responseMessage,
                            cause = e
                        )
                    } catch (exc: Exception) {
                        exc.printStackTrace()

                        keyValueStorage.accessToken = null
                        keyValueStorage.refreshToken = null

                        throw DeadTokenException(
                            message = exc.message.orEmpty(),
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
