package vn.teko.sandbox.ui.home

import android.app.Activity
import android.content.Intent
import android.os.Build
import android.text.Html
import android.view.inputmethod.EditorInfo
import androidx.fragment.app.viewModels
import vn.teko.android.auth.login.ui.LoginUIConfigBuilder
import vn.teko.android.auth.login.ui.TerraAuthUI
import vn.teko.android.core.ui.base.BaseFragment
import vn.teko.android.core.ui.util.ViewState
import vn.teko.android.core.util.android.extension.setOnSingleClickListener
import vn.teko.android.core.util.android.extension.showToast
import vn.teko.android.core.util.android.livedata.SingleHandlerEventObserver
import vn.teko.android.terra.auth.TerraAuthInterface
import vn.teko.android.tracker.manager.TerraTracker
import vn.teko.apollo.component.popup.ApolloAlertConfirmationBuilder
import vn.teko.apollo.component.spinner.ApolloDropdown
import vn.teko.hestia.core.HestiaInterface
import vn.teko.hestia.core.model.AppType
import vn.teko.hestia.core.util.HestiaError
import vn.teko.sandbox.BR
import vn.teko.sandbox.R
import vn.teko.sandbox.databinding.FragmentHomeBinding
import vn.teko.sandbox.error.OpenMiniAppError
import vn.teko.sandbox.ui.home.model.MiniAppDropDownItem
import vn.teko.sandbox.ui.home.model.Scenario
import vn.teko.sandbox.ui.home.model.ScenarioDropDownItem
import vn.teko.sandbox.utils.DropdownGenerator
import vn.teko.sandbox.utils.SharedPreferenceUtils
import javax.inject.Inject


/**
 * Created by TrungCS on 23/09/2021.
 * Email: trung.cs@teko.vn
 * Company: Teko
 */
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>() {

    private val homeViewModel: HomeViewModel by viewModels { viewModelFactory }

    @Inject
    lateinit var loginUI: TerraAuthUI

    @Inject
    lateinit var authManager: TerraAuthInterface

    @Inject
    lateinit var hestia: HestiaInterface

    private var selectedMiniAppIndex = 0
        set(value) {
            if (field != value) {
                field = value
                viewDataBinding.ddMiniAppType.setSelection(value)
                homeViewModel.setMiniAppType(
                    viewDataBinding.ddMiniAppType
                        .getSelectedItem<MiniAppDropDownItem>()?.type ?: AppType.ReactNativeAndroid
                )
            }
        }

    private var selectedScenarioIndex = 0
        set(value) {
            if (field != value) {
                field = value
                viewDataBinding.ddScenario.setSelection(value)
                homeViewModel.setScenario(
                    viewDataBinding.ddScenario.getSelectedItem<ScenarioDropDownItem>()?.type
                        ?: Scenario.Default
                )
            }
        }

    override fun getViewModel() = homeViewModel

    override fun getBindingVariable(): Int = BR.viewModel

    override fun getLayoutId() = R.layout.fragment_home

    override fun initComponents() {
        observeEvents()
        setupView()

        TerraTracker.getInstance()
    }

    private fun setupView() {
        viewDataBinding.apply {
            ddScenario.setDropdownList(DropdownGenerator.getScenarioDropdown(requireContext()))
            ddMiniAppType.setDropdownList(DropdownGenerator.getMiniAppDropdown(requireContext()))

            val savedConfig =
                SharedPreferenceUtils.getSavedDropdownPosition(requireContext())
            selectedMiniAppIndex = savedConfig.first
            selectedScenarioIndex = savedConfig.second
            homeViewModel.setMiniAppCode(savedConfig.third ?: "")

            ddMiniAppType.setItemSelectedListener(object :
                ApolloDropdown.DropdownSelectedListener<MiniAppDropDownItem> {
                override fun onItemSelectedListener(index: Int, model: MiniAppDropDownItem) {
                    selectedMiniAppIndex = index
                }
            })

            ddScenario.setItemSelectedListener(object :
                ApolloDropdown.DropdownSelectedListener<ScenarioDropDownItem> {
                override fun onItemSelectedListener(index: Int, model: ScenarioDropDownItem) {
                    if (selectedScenarioIndex != index) {
                        selectedScenarioIndex = index
                        homeViewModel.updateMiniAppCode()
                    }
                }
            })

            btnOpenMiniApp.setOnSingleClickListener {
                openMiniApp()
            }

            ffMiniAppCode.getEditText().isSingleLine = true
            ffMiniAppCode.getEditText().setOnEditorActionListener { _, id, _ ->
                if (id == EditorInfo.IME_ACTION_DONE) {
                    openMiniApp()
                    return@setOnEditorActionListener true
                }

                return@setOnEditorActionListener false
            }
        }
    }

    private fun openMiniApp() {
        homeViewModel.openMiniApp()
        saveSelectedAppConfig()
    }

    private fun observeEvents() {
        homeViewModel.apply {
            openLoginEvent.observe(viewLifecycleOwner, SingleHandlerEventObserver {
                openLoginUI()
            })

            logoutEvent.observe(viewLifecycleOwner, SingleHandlerEventObserver {
                logout()
            })

            openMiniAppErrorEvent.observe(viewLifecycleOwner, SingleHandlerEventObserver {
                showOpeningMiniAppError(it)
            })

            currentMiniAppType.observe(viewLifecycleOwner) {
                if (it == AppType.WebView) {
                    prefillWebMiniAppUrl()
                    setWebMiniAppUrlHintIfNeeded()
                }
            }

            getState().observe(viewLifecycleOwner) {
                when (it) {
                    is ViewState.LOADING -> {
                        showLoading()
                    }
                    else -> {
                        hideLoading()
                    }
                }
            }
        }
    }

    private fun saveSelectedAppConfig() {
        SharedPreferenceUtils.saveSelectedConfig(
            requireContext(),
            selectedMiniAppIndex,
            selectedScenarioIndex,
            homeViewModel.miniAppCode.value.orEmpty()
        )
        SharedPreferenceUtils.saveWebMiniAppUrl(
            requireContext(),
            homeViewModel.customWebMiniAppUrl.value.orEmpty()
        )
    }

    private fun showOpeningMiniAppError(error: Throwable) {
        val errorRes = when (error) {
            is HestiaError.MiniAppNotFound -> R.string.mini_app_not_found_error
            is HestiaError.ExchangeTokenFailed -> R.string.exchange_token_failed
            is HestiaError.MissingAccessToken -> R.string.missing_access_token
            is OpenMiniAppError.EmptyAppCodeError -> R.string.empty_mini_app_code_error
            is OpenMiniAppError.NotLoggedIn -> R.string.not_logged_in
            else -> R.string.common_error
        }

        showCommonError(getString(errorRes))
    }

    private fun openLoginUI() {
        loginUI.startLogin(this, LoginUIConfigBuilder().build())
    }

    private fun logout() {
        showLoading()
        authManager.logOut {
            hideLoading()
            val message = if (it) {
                R.string.succeed_logout_message
            } else {
                R.string.failed_logout_message
            }
            showToast(message)

            homeViewModel.updateLoginStatus()
        }
    }

    private fun prefillWebMiniAppUrl() {
        viewDataBinding.ffWebMiniAppUrl.text = SharedPreferenceUtils.getWebMiniAppUrl(requireContext())
    }

    private fun setWebMiniAppUrlHintIfNeeded() {
        if (viewDataBinding.tvWebMiniAppUrlHint.text.isNullOrEmpty()) {
            val hint = getString(R.string.web_mini_app_url_hint)
            viewDataBinding.tvWebMiniAppUrlHint.text = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                Html.fromHtml(hint, Html.FROM_HTML_MODE_COMPACT)
            } else {
                Html.fromHtml(hint)
            }
        }
    }

    override fun onResume() {
        super.onResume()
        homeViewModel.updateLoginStatus()
    }

    private fun showCommonError(errorMessage: String) {
        ApolloAlertConfirmationBuilder(requireContext())
            .withTitle(getString(R.string.common_dialog_title))
            .withContent(errorMessage)
            .withPrimaryAction(getString(R.string.common_close))
            .cancelable(true)
            .show()
    }

    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        data: Intent?
    ) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == TerraAuthUI.LOGIN_UI_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            showToast(R.string.succeed_login)
        }
    }
}