package com.core.data.model

import com.core.data.infrastructure.ConfigAppProvider
import com.core.data.infrastructure.KeyValueStorage

data class ConfigParams(
    val keyValueStorage: KeyValueStorage,
    val configAppProvider: ConfigAppProvider,
)