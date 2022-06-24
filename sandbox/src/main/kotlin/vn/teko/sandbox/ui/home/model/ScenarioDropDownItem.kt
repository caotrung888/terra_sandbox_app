package vn.teko.sandbox.ui.home.model

import vn.teko.apollo.component.spinner.DropdownItem


/**
 * Created by TrungCS on 27/09/2021.
 * Email: trung.cs@teko.vn
 * Company: Teko
 */
data class ScenarioDropDownItem(
    val context: String,
    val type: Scenario
) : DropdownItem {
    override fun getDisplayIcon() = 0

    override fun getDisplayText() = context
}