package vn.teko.sandbox.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.map
import vn.teko.android.core.ui.base.BaseView
import vn.teko.android.core.ui.base.BaseViewModel
import vn.teko.android.core.ui.util.ViewState
import vn.teko.android.core.util.android.livedata.SingleHandlerEvent
import vn.teko.android.terra.auth.TerraAuthInterface
import vn.teko.hestia.android.webapp.WebExtraDevelopmentConfigBuilder
import vn.teko.hestia.core.HestiaCallback
import vn.teko.hestia.core.HestiaInterface
import vn.teko.hestia.core.model.AppType
import vn.teko.hestia.core.util.HestiaError
import vn.teko.sandbox.error.OpenMiniAppError
import vn.teko.sandbox.ui.home.model.SSA_APP_CODE_SCENARIO_1
import vn.teko.sandbox.ui.home.model.SSA_APP_CODE_SCENARIO_2
import vn.teko.sandbox.ui.home.model.SSA_APP_CODE_SCENARIO_3
import vn.teko.sandbox.ui.home.model.Scenario
import javax.inject.Inject


/**
 * Created by TrungCS on 26/09/2021.
 * Email: trung.cs@teko.vn
 * Company: Teko
 */
class HomeViewModel @Inject constructor(
    private val terraAuthInterface: TerraAuthInterface,
    private val hestiaInterface: HestiaInterface,
) : BaseViewModel<BaseView>() {

    val miniAppCode = MutableLiveData("")

    val customWebMiniAppUrl = MutableLiveData("")

    private val _openLoginEvent = MutableLiveData<SingleHandlerEvent<Unit>>()
    val openLoginEvent: LiveData<SingleHandlerEvent<Unit>>
        get() = _openLoginEvent

    private val _openMiniAppErrorEvent = MutableLiveData<SingleHandlerEvent<Throwable>>()
    val openMiniAppErrorEvent: LiveData<SingleHandlerEvent<Throwable>>
        get() = _openMiniAppErrorEvent

    private val _logoutEvent = MutableLiveData<SingleHandlerEvent<Unit>>()
    val logoutEvent: LiveData<SingleHandlerEvent<Unit>>
        get() = _logoutEvent

    private val _currentMiniAppType = MutableLiveData(AppType.ReactNativeAndroid)
    val currentMiniAppType: LiveData<AppType> = _currentMiniAppType

    private val _currentScenario = MutableLiveData(Scenario.Default)
    val currentScenario: LiveData<Scenario> = _currentScenario

    private val _isLogged = MutableLiveData<Boolean>()
    val isLogged: LiveData<Boolean> = _isLogged

    val showLoginButton: LiveData<Boolean> = _currentScenario.map {
        !it.isDefault()
    }

    fun updateLoginStatus() {
        terraAuthInterface.isAuthorized {
            _isLogged.value = it
        }
    }

    fun setScenario(scenario: Scenario) {
        _currentScenario.value = scenario
    }

    fun setMiniAppType(appType: AppType) {
        _currentMiniAppType.value = appType
    }

    fun handleLogin() {
        if (_isLogged.value == true) {
            _logoutEvent.value = SingleHandlerEvent(Unit)
        } else {
            _openLoginEvent.value = SingleHandlerEvent(Unit)
        }
    }

    fun openMiniApp() {
        val callback = object : HestiaCallback {
            override fun onError(error: HestiaError) {
                setState(ViewState.IDLE)

                if (error is HestiaError.ExchangeTokenFailed && _isLogged.value == false) {
                    _openMiniAppErrorEvent.value = SingleHandlerEvent(OpenMiniAppError.NotLoggedIn)
                } else {
                    _openMiniAppErrorEvent.value = SingleHandlerEvent(error)
                }
            }

            override fun onSuccess() {
                setState(ViewState.IDLE)
            }
        }

        val currentMiniAppCode = when (val scenario = getScenario()) {
            Scenario.Default -> scenario.miniAppCode
            else -> miniAppCode.value ?: ""
        }

        if (currentMiniAppCode.isBlank()) {
            _openMiniAppErrorEvent.value = SingleHandlerEvent(OpenMiniAppError.EmptyAppCodeError)
            return
        }

        setState(ViewState.LOADING)
        hestiaInterface.startApp(
            currentMiniAppCode,
            getMiniAppType(),
            getExtraConfig(),
            callback
        )
    }

    private fun getCustomWebMiniAppUrl() = customWebMiniAppUrl.value.orEmpty().trim()

    private fun getMiniAppType() = currentMiniAppType.value ?: AppType.NativeAndroid

    private fun getScenario() = currentScenario.value ?: Scenario.Default

    fun updateMiniAppCode() {
        val currentAppCode = miniAppCode.value

        if (currentAppCode.isNullOrBlank() || isCodeBelongToDefaultCode(currentAppCode)) {
            setMiniAppCode(currentScenario.value?.miniAppCode ?: "")
        }
    }

    fun setMiniAppCode(code: String) {
        miniAppCode.postValue(code)
    }

    fun resetAppCode() {
        setMiniAppCode(currentScenario.value?.miniAppCode ?: "")
    }

    private fun isCodeBelongToDefaultCode(code: String): Boolean {
        return code == SSA_APP_CODE_SCENARIO_1
            || code == SSA_APP_CODE_SCENARIO_2
            || code == SSA_APP_CODE_SCENARIO_3
    }

    private fun getExtraConfig() = if (getMiniAppType() == AppType.WebView) {
        WebExtraDevelopmentConfigBuilder().apply {
            val customWebMiniAppUrl = getCustomWebMiniAppUrl()
            if (customWebMiniAppUrl.isNotEmpty()) {
                setCustomBaseUrl(customWebMiniAppUrl)
            }
            setDebuggable(true)
        }.buildConfigMap()
    } else emptyMap()

}

