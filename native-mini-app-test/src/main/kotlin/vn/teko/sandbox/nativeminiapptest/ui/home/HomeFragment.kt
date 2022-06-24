package vn.teko.sandbox.nativeminiapptest.ui.home

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import vn.teko.sandbox.nativeminiapptest.R
import vn.teko.sandbox.nativeminiapptest.cart.CartManager
import vn.teko.sandbox.nativeminiapptest.databinding.FragmentProductListBinding
import vn.teko.sandbox.nativeminiapptest.model.Product
import vn.teko.sandbox.nativeminiapptest.utils.ProductFactory

class HomeFragment : Fragment(R.layout.fragment_product_list), ProductListListener {
    private lateinit var viewDataBinding: FragmentProductListBinding
    private var productAdapter = ProductListAdapter(listOf())

//
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View {
//
//        viewDataBinding =
//            DataBindingUtil.inflate(inflater, R.layout.fragment_product_list, container, false)
////            FragmentProductListBinding.inflate(inflater,  container, false)
//        return viewDataBinding.root
//    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        viewDataBinding.lifecycleOwner = viewLifecycleOwner
        productAdapter.dataSet = ProductFactory.getMockProduct()

        val listview = getView()?.findViewById<RecyclerView>(R.id.rvProductList) ?: return

        listview.layoutManager = GridLayoutManager(context, 2)
        listview.adapter = productAdapter
        productAdapter.listener = this
    }

    override fun onProductItemClick(product: Product) {
    }

    override fun onAddProductToCart(product: Product) {
        CartManager.addToCart(product, 1)
        Toast.makeText(requireContext(), R.string.added_to_cart, Toast.LENGTH_SHORT).show()
    }
}

interface ProductListListener {
    fun onProductItemClick(product: Product)

    fun onAddProductToCart(product: Product)
}

