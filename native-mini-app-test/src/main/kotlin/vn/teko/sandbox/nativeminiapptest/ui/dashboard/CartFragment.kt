package vn.teko.sandbox.nativeminiapptest.ui.dashboard

import android.app.ProgressDialog
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import vn.teko.android.payment.kit.PaymentKit
import vn.teko.android.payment.kit.PaymentResultV2Callback
import vn.teko.android.payment.kit.model.request.PaymentRequestBuilder
import vn.teko.android.payment.kit.model.request.PaymentV2Request
import vn.teko.android.payment.kit.model.result.PaymentV2Result
import vn.teko.sandbox.nativeminiapptest.R
import vn.teko.sandbox.nativeminiapptest.cart.CartManager
import vn.teko.sandbox.nativeminiapptest.utils.MoneyFormatter
import kotlin.math.roundToLong

class CartFragment : Fragment(R.layout.fragment_cart) {
    private lateinit var cartItemListAdapter: CartItemListAdapter
    private lateinit var linearLayoutManager: LinearLayoutManager

    private lateinit var rcvCartItems: RecyclerView
    private lateinit var btnCheckout: Button
    private lateinit var tvGrandTotal: TextView

    private val orderCode: String = System.currentTimeMillis().toString()

    private var progressDialog: ProgressDialog? = null

    private fun getGrandTotal() = CartManager.getItems().sumOf { it.totalPrice }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rcvCartItems = getView()?.findViewById(R.id.rcvCartItems) ?: return
        btnCheckout = getView()?.findViewById(R.id.btnCheckout) ?: return
        tvGrandTotal = getView()?.findViewById(R.id.tvGrandTotal) ?: return

        setupView()
    }

    private fun setupView() {
        linearLayoutManager = LinearLayoutManager(requireContext())
        cartItemListAdapter = CartItemListAdapter()
        rcvCartItems.adapter = cartItemListAdapter
        rcvCartItems.layoutManager = linearLayoutManager
        updateCartState()

        btnCheckout.setOnClickListener {
            val message =
                getString(R.string.payment_confirm, tvGrandTotal.text, orderCode)
            AlertDialog.Builder(requireContext())
                .setMessage(message)
                .setPositiveButton(R.string.yes) { _, _ ->
                    performPayment()
                }
                .setNegativeButton(R.string.cancel) { _, _ -> }
                .setCancelable(false)
                .show()
        }
    }

    private fun updateCartState() {
        tvGrandTotal.text = MoneyFormatter.formatVND(getGrandTotal())
        cartItemListAdapter.setItems(CartManager.getItems())
    }

    private fun performPayment() {
        val grantTotal = 100000L
        if (grantTotal <= 0) return

        val paymentCallbackV2 = object : PaymentResultV2Callback {
            override fun onResult(result: PaymentV2Result) {
                hideLoading()
                val paymentResultStatus = when (result.resultCode) {
                    PaymentV2Result.RESULT_CANCELED -> R.string.cancelled_payment
                    PaymentV2Result.RESULT_FAILED -> R.string.failed_payment
                    else -> {
                        CartManager.clear()
                        updateCartState()
                        R.string.success_payment
                    }
                }

                AlertDialog.Builder(requireContext())
                    .setMessage(paymentResultStatus)
                    .setPositiveButton(R.string.OK) { _, _ -> }
                    .create()
                    .show()
            }
        }

        val paymentRequestBuilder =
            PaymentRequestBuilder(
                PaymentV2Request.Order(
                    orderCode = orderCode,
                    orderAmount = getGrandTotal().roundToLong(),
                    displayOrderCode = DISPLAY_ORDER_CODE
                )
            )
                .setMainMethod(
                    PaymentV2Request.Payment.MainMethod(
                        PaymentV2Request.Payment.Method.All,
                        grantTotal,
                    )
                )

        showLoading()
        PaymentKit.payForOrder(
            null,
            paymentRequest = paymentRequestBuilder.build(),
            callback = paymentCallbackV2
        )
    }

    private fun showLoading() {
        context?.also {
            if (progressDialog == null) {
                progressDialog = ProgressDialog(it)
                progressDialog?.setTitle("Loading")
                progressDialog?.show();
            } else if (progressDialog?.isShowing == false) {
                progressDialog!!.show()
            }
        }
    }

    /**
     * cleanup any loading behavior has taken before
     */
    private fun hideLoading() {
        progressDialog?.dismiss()
        progressDialog = null
    }

    companion object {
        private const val DISPLAY_ORDER_CODE = "Sandbox-native-mini-app"
    }
}
