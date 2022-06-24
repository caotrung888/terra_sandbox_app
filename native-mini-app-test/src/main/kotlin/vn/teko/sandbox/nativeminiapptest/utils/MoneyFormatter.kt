package vn.teko.sandbox.nativeminiapptest.utils

import java.text.DecimalFormat
import java.util.*


/**
 * Created by TrungCS on 28/09/2021.
 * Email: trung.cs@teko.vn
 * Company: Teko
 */
object MoneyFormatter {
    fun formatVND(amount: Double): String {
        val locale = Locale("vi", "VN")
        val formatter = DecimalFormat.getCurrencyInstance(locale) as DecimalFormat
        val symbol = formatter.decimalFormatSymbols
        symbol.currencySymbol = ""
        formatter.decimalFormatSymbols = symbol

        return "${formatter.format(amount).trim()}₫"
    }
}