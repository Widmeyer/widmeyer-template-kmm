package com.widmeyertemplate.core.data.model

import com.widmeyertemplate.core.data.infrastructure.ConfigAppProvider
import com.widmeyertemplate.core.data.infrastructure.KeyValueStorage

data class ConfigParams(
    val keyValueStorage: KeyValueStorage,
    val configAppProvider: ConfigAppProvider,
)