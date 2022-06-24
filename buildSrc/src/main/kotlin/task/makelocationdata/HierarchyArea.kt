package task.makelocationdata

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class HierarchyArea(

    @Expose
    @SerializedName("name")
    val name: String,

    @Expose
    @SerializedName("children")
    val children: Map<String, HierarchyArea>? = null

)