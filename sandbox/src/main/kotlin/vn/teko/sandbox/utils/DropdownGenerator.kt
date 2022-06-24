package vn.teko.sandbox.utils

import android.content.Context
import vn.teko.hestia.core.model.AppType
import vn.teko.sandbox.R
import vn.teko.sandbox.ui.home.model.MiniAppDropDownItem
import vn.teko.sandbox.ui.home.model.Scenario
import vn.teko.sandbox.ui.home.model.ScenarioDropDownItem


/**
 * Created by TrungCS on 27/09/2021.
 * Email: trung.cs@teko.vn
 * Company: Teko
 */
object DropdownGenerator {
    fun getMiniAppDropdown(context: Context): List<MiniAppDropDownItem> {
        return context.run {
            listOf(
                MiniAppDropDownItem(
                    getString(R.string.mini_app_type_react_native),
                    AppType.ReactNativeAndroid
                ),
                MiniAppDropDownItem(
                    getString(R.string.mini_app_type_native),
                    AppType.NativeAndroid
                ),
                MiniAppDropDownItem(getString(R.string.mini_app_type_web), AppType.WebView),
            )
        }
    }

    fun getScenarioDropdown(context: Context): List<ScenarioDropDownItem> {
        return context.run {
            listOf(
                ScenarioDropDownItem(
                    getString(R.string.scenario_type_default),
                    Scenario.Default
                ),
                ScenarioDropDownItem(
                    getString(R.string.scenario_type_authentication),
                    Scenario.Authentication
                ),
                ScenarioDropDownItem(
                    getString(R.string.scenario_type_payment),
                    Scenario.Payment
                )
            )
        }
    }
}