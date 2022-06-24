package vn.teko.sandbox.nativeminiapptest.cart

import vn.teko.sandbox.nativeminiapptest.model.Product
import java.util.*


/**
 * Created by TrungCS on 28/09/2021.
 * Email: trung.cs@teko.vn
 * Company: Teko
 */
object CartManager {
    private var items: MutableList<LineItem> = mutableListOf()

    fun getItems(): List<LineItem> = items

    fun addToCart(product: Product, quantity: Int): LineItem {
        val newItem = LineItem(
            id = UUID.randomUUID().toString(),
            product = product,
            quantity = quantity,
            price = product.prices.firstOrNull()?.latestPrice?.toDouble() ?: 0.0
        )

        var sameItemInCart: LineItem? = null
        val newItems = items.map {
            if (isSameProduct(it, newItem)) {
                sameItemInCart = it
                it.copy(quantity = it.quantity + newItem.quantity)
            } else {
                it
            }
        }

        return if (sameItemInCart != null) {
            items = newItems.toMutableList()
            sameItemInCart!!
        } else {
            items.add(newItem)
            newItem
        }
    }

    fun changeItemQuantity(
        itemId: String,
        quantity: Int
    ): List<LineItem> {
        return items.map { item ->
            if (item.id == itemId) {
                item.copy(quantity = quantity)
            } else {
                item
            }
        }.toMutableList()
    }

    data class LineItem(
        val id: String,
        val product: Product,
        val quantity: Int,
        val price: Double
    ) {
        val totalPrice: Double get() = price * quantity
    }

    private fun isSameProduct(firstItem: LineItem, secondItem: LineItem) =
        firstItem.product.productInfo.sku == secondItem.product.productInfo.sku

    fun clear() {
        items.clear()
    }
}
