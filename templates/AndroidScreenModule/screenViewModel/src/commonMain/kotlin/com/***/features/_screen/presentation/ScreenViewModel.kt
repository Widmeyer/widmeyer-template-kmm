package com.deliveryms.features.screen.presentation

import com.deliveryms.data.model.ConfigParams
import com.deliveryms.data.model.isConnectionException
import com.deliveryms.domain.constants.Constants
import com.deliveryms.domain.repositories.OfflineOrdersRepository
import com.deliveryms.entity.DeadTokenException
import com.deliveryms.entity.enums.CourierStatus
import com.deliveryms.features.base.LiveData
import com.deliveryms.features.base.ViewModel
import com.deliveryms.features.splash.utils.LocationChecker
import dev.icerock.moko.network.generated.apis.AuthenticationApi
import dev.icerock.moko.network.generated.apis.ConfigurationApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
class ScreenViewModel(): ViewModel() {
    init {

}