package vn.teko.sandbox.nativeminiapptest.ui.home

import android.graphics.drawable.Drawable
import android.graphics.drawable.VectorDrawable
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.google.android.material.button.MaterialButton
import vn.teko.sandbox.nativeminiapptest.R
import vn.teko.sandbox.nativeminiapptest.model.Product
import vn.teko.sandbox.nativeminiapptest.utils.MoneyFormatter


/**
 * Created by TrungCS on 28/09/2021.
 * Email: trung.cs@teko.vn
 * Company: Teko
 */
class ProductListAdapter(internal var dataSet: List<Product>) :
    RecyclerView.Adapter<ProductListAdapter.ViewHolder>() {

    internal var listener: ProductListListener? = null

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvProductName: AppCompatTextView
        val ivProductImage: AppCompatImageView
        val btnAddToCart: MaterialButton
        val tvProductPrice: AppCompatTextView
        val containerView: View

        init {
            // Define click listener for the ViewHolder's View.
            tvProductName = view.findViewById(R.id.tvProductName)
            tvProductPrice = view.findViewById(R.id.tvProductSalePrice)
            ivProductImage = view.findViewById(R.id.ivProductImage)
            btnAddToCart = view.findViewById(R.id.btnAddToCart)
            containerView = view.findViewById(R.id.cvContainer)
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_grid_product, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val product = dataSet[position]

        viewHolder.apply {
            tvProductName.text = product.productInfo.name
            ivProductImage.setRoundImageWithProgress(product.productInfo.imageUrl)
            tvProductPrice.text =
                MoneyFormatter.formatVND(
                    product.prices.firstOrNull()?.latestPrice?.toDouble() ?: 0.0
                )
            btnAddToCart.setOnClickListener { listener?.onAddProductToCart(product) }
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}

fun ImageView.setRoundImageWithProgress(
    image: Any?, // url or drawable
    width: Int = com.bumptech.glide.request.target.Target.SIZE_ORIGINAL,
    height: Int = com.bumptech.glide.request.target.Target.SIZE_ORIGINAL,
    radius: Int = 0,
    placeholder: Drawable? = null,
    error: Drawable? = null,
    callback: (() -> Unit)? = null
) {
    var requestOptions = RequestOptions()
        .override(width, height)

    requestOptions = requestOptions.placeholder(placeholder)

    if (error != null) {
        requestOptions = requestOptions.error(error)
    }

    when {
        radius == Int.MAX_VALUE -> requestOptions.circleCrop()
        radius > 0 -> requestOptions.transform(CenterCrop(), RoundedCorners(radius))
    }

    val cacheStrategy = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        when (image) {
            is Int -> DiskCacheStrategy.AUTOMATIC
            is VectorDrawable -> DiskCacheStrategy.AUTOMATIC
            else -> DiskCacheStrategy.RESOURCE
        }
    } else {
        when (image) {
            is Int -> DiskCacheStrategy.AUTOMATIC
            else -> DiskCacheStrategy.RESOURCE
        }
    }
    Glide.with(context)
        .load(image ?: "")
        .apply(requestOptions)
        .diskCacheStrategy(cacheStrategy)
        .listener(object : RequestListener<Drawable> {
            override fun onResourceReady(
                resource: Drawable?,
                model: Any?,
                target: com.bumptech.glide.request.target.Target<Drawable>?,
                dataSource: DataSource?,
                isFirstResource: Boolean
            ): Boolean {
                return false
            }

            override fun onLoadFailed(
                e: GlideException?,
                model: Any?,
                target: com.bumptech.glide.request.target.Target<Drawable>?,
                isFirstResource: Boolean
            ): Boolean {
                callback?.invoke()
                return false
            }
        })
        .into(this)
}

