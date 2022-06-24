package vn.teko.sandbox.ui.home.model

import vn.teko.apollo.component.spinner.DropdownItem
import vn.teko.hestia.core.model.AppType


/**
 * Created by TrungCS on 27/09/2021.
 * Email: trung.cs@teko.vn
 * Company: Teko
 */
data class MiniAppDropDownItem(
    val context: String,
    val type: AppType
) : DropdownItem {
    override fun getDisplayIcon() = 0

    override fun getDisplayText() = context
}