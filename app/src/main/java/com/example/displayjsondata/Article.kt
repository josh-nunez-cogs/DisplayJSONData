package com.example.displayjsondata
import com.google.gson.annotations.SerializedName

data class Article(
    @SerializedName("Art") val name: String,
    @SerializedName("Qnt") val quantity: Int,
    @SerializedName("Prize") val prize: Double,
    @SerializedName("Total") val total: Double
)