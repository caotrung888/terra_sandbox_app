package vn.teko.sandbox.nativeminiapptest.model


/**
 * Created by TrungCS on 28/09/2021.
 * Email: trung.cs@teko.vn
 * Company: Teko
 */
data class Product(
    var productInfo: ProductInfo = ProductInfo(),
    var prices: List<Price> = listOf(),
)

data class Price(
    var supplierRetailPrice: String = "",
    var terminalPrice: String = "",
    var latestPrice: String = "",
    var discountAmount: String = "",
    var discountPercent: Double = 0.0,
    var sellPrice: String = ""
)

data class ProductInfo(
    var sku: String = "",
    var skuId: String = "",
    var name: String = "",
    var imageUrl: String = "",
    var tags: List<String> = listOf()
)

