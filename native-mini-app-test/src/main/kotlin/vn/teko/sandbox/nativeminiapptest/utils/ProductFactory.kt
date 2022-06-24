package vn.teko.sandbox.nativeminiapptest.utils

import vn.teko.sandbox.nativeminiapptest.model.Price
import vn.teko.sandbox.nativeminiapptest.model.Product
import vn.teko.sandbox.nativeminiapptest.model.ProductInfo
import kotlin.random.Random


/**
 * Created by TrungCS on 28/09/2021.
 * Email: trung.cs@teko.vn
 * Company: Teko
 */
internal object ProductFactory {
    fun getMockProduct(): List<Product> {
        val productList = mutableListOf<Product>()
        productList.add(
            productFactory(
                "Smart Tivi TCL 4K 65 inch L65P65-UF",
                "https://lh3.googleusercontent.com/-WUotQ05WjTwpPHnOA0ZOF3BdJoan68H8DVEy_DpfmOULHwdv0cdFte8H95uTWkykeVWIGpAKJEYrj9KNhM=w500-rw"
            )
        )
        productList.add(
            productFactory(
                "A sentence ends with punctuation",
                "https://lh3.googleusercontent.com/-WUotQ05WjTwpPHnOA0ZOF3BdJoan68H8DVEy_DpfmOULHwdv0cdFte8H95uTWkykeVWIGpAKJEYrj9KNhM=w500-rw"
            )
        )
        productList.add(
            productFactory(
                "Chim Cò",
                "https://lh3.googleusercontent.com/-WUotQ05WjTwpPHnOA0ZOF3BdJoan68H8DVEy_DpfmOULHwdv0cdFte8H95uTWkykeVWIGpAKJEYrj9KNhM=w500-rw"
            )
        )
        productList.add(
            productFactory(
                "I like cats of the Turkish Van breed.",
                "https://lh3.googleusercontent.com/-WUotQ05WjTwpPHnOA0ZOF3BdJoan68H8DVEy_DpfmOULHwdv0cdFte8H95uTWkykeVWIGpAKJEYrj9KNhM=w500-rw"
            )
        )
        productList.add(
            productFactory(
                "And even increase the",
                "https://lh3.googleusercontent.com/-WUotQ05WjTwpPHnOA0ZOF3BdJoan68H8DVEy_DpfmOULHwdv0cdFte8H95uTWkykeVWIGpAKJEYrj9KNhM=w500-rw"
            )
        )
        productList.add(
            productFactory(
                "Isn’t it crazy how we just went from the most basic sentence, ",
                "https://lh3.googleusercontent.com/-WUotQ05WjTwpPHnOA0ZOF3BdJoan68H8DVEy_DpfmOULHwdv0cdFte8H95uTWkykeVWIGpAKJEYrj9KNhM=w500-rw"
            )
        )
        productList.add(
            productFactory(
                "A sentence ends with punctuation",
                "https://lh3.googleusercontent.com/-WUotQ05WjTwpPHnOA0ZOF3BdJoan68H8DVEy_DpfmOULHwdv0cdFte8H95uTWkykeVWIGpAKJEYrj9KNhM=w500-rw"
            )
        )
        productList.add(
            productFactory(
                "If you want to build a solid structure, you need to put down the first few blocks in the right place.",
                "https://lh3.googleusercontent.com/-WUotQ05WjTwpPHnOA0ZOF3BdJoan68H8DVEy_DpfmOULHwdv0cdFte8H95uTWkykeVWIGpAKJEYrj9KNhM=w500-rw"
            )
        )
        productList.add(
            productFactory(
                "I like cats of the Turkish Van breed.",
                "https://lh3.googleusercontent.com/-WUotQ05WjTwpPHnOA0ZOF3BdJoan68H8DVEy_DpfmOULHwdv0cdFte8H95uTWkykeVWIGpAKJEYrj9KNhM=w500-rw"
            )
        )
        productList.add(
            productFactory(
                "And even increase the",
                "https://lh3.googleusercontent.com/-WUotQ05WjTwpPHnOA0ZOF3BdJoan68H8DVEy_DpfmOULHwdv0cdFte8H95uTWkykeVWIGpAKJEYrj9KNhM=w500-rw"
            )
        )
        productList.add(
            productFactory(
                "Isn’t it crazy how we just went from the most basic sentence, ",
                "https://lh3.googleusercontent.com/-WUotQ05WjTwpPHnOA0ZOF3BdJoan68H8DVEy_DpfmOULHwdv0cdFte8H95uTWkykeVWIGpAKJEYrj9KNhM=w500-rw"
            )
        )

        return productList
    }

    private fun productFactory(name: String, imageUrl: String) = Product().apply {
        productInfo =
            ProductInfo(sku = Random.nextInt(0, 1000).toString(), name = name, imageUrl = imageUrl)
        prices = listOf(Price(latestPrice = Random.nextDouble(10000.0, 100000.0).toString()))
    }
}
