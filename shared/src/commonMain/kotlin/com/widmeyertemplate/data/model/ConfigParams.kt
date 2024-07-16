package com.widmeyertemplate.data.model

import com.widmeyertemplate.data.infrastructure.ConfigAppProvider
import com.widmeyertemplate.data.infrastructure.KeyValueStorage

data class ConfigParams(
    val keyValueStorage: KeyValueStorage,
    val configAppProvider: ConfigAppProvider,
)