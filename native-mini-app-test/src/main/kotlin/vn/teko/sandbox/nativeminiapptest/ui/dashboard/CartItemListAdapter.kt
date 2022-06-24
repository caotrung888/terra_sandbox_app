package vn.teko.sandbox.nativeminiapptest.ui.dashboard

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import vn.teko.sandbox.nativeminiapptest.R
import vn.teko.sandbox.nativeminiapptest.cart.CartManager
import vn.teko.sandbox.nativeminiapptest.databinding.ItemCartBinding
import vn.teko.sandbox.nativeminiapptest.ui.home.setRoundImageWithProgress
import vn.teko.sandbox.nativeminiapptest.utils.MoneyFormatter


/**
 * Created by TrungCS on 28/09/2021.
 * Email: trung.cs@teko.vn
 * Company: Teko
 */
internal class CartItemListAdapter :
    RecyclerView.Adapter<CartItemListAdapter.CartItemViewHolder>() {

    private val items = mutableListOf<CartManager.LineItem>()

    @SuppressLint("NotifyDataSetChanged")
    fun setItems(items: List<CartManager.LineItem>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemBinding = ItemCartBinding.inflate(layoutInflater, parent, false)
        return CartItemViewHolder(itemBinding)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: CartItemViewHolder, position: Int) {
        holder.onBind(position)
    }

    inner class CartItemViewHolder(
        private val itemBinding: ItemCartBinding,
    ) : RecyclerView.ViewHolder(itemBinding.root) {
        private var currentItem: CartManager.LineItem? = null

        fun onBind(position: Int) {
            currentItem = items[position]
            itemBinding.apply {
                lineItem = items[position]
                ivProductImage.setRoundImageWithProgress(currentItem?.product?.productInfo?.imageUrl)
                tvProductPrice.text = MoneyFormatter.formatVND(currentItem?.price ?: 0.0)
                tvQuantity.text =
                    tvQuantity.context.getString(R.string.quantity, currentItem?.quantity ?: 0)

                executePendingBindings()
            }
        }
    }
}
