package task.makelocationdata

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Areas(

    @Expose
    @SerializedName("code")
    val code: Int,

    @Expose
    @SerializedName("message")
    val message: String,

    @Expose
    @SerializedName("data")
    val data: List<Area>

) {

    data class Area(

        @Expose
        @SerializedName("code")
        val code: String,

        @Expose
        @SerializedName("parent_code")
        val parentCode: String?,

        @Expose
        @SerializedName("name")
        val name: String

    )

}