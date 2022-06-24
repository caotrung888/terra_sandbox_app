package vn.teko.sandbox.ui.home.model


/**
 * Created by TrungCS on 27/09/2021.
 * Email: trung.cs@teko.vn
 * Company: Teko
 */

const val SSA_APP_CODE_SCENARIO_1 = "ssa-mini-app-tc1"
const val SSA_APP_CODE_SCENARIO_2 = "ssa-mini-app-tc2"
const val SSA_APP_CODE_SCENARIO_3 = "ssa-mini-app-tc3"

enum class Scenario(val miniAppCode: String) {
    Default(SSA_APP_CODE_SCENARIO_1),
    Authentication(SSA_APP_CODE_SCENARIO_2),
    Payment(SSA_APP_CODE_SCENARIO_3);

    fun isDefault() = this == Default
    fun isPayment() = this == Payment
}
