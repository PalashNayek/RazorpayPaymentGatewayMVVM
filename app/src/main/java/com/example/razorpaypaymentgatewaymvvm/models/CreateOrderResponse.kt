package com.example.razorpaypaymentgatewaymvvm.models

import com.google.gson.annotations.SerializedName

data class CreateOrderResponse(
    @SerializedName("id") val id: String,
    @SerializedName("amount") val amount: Int,
    @SerializedName("currency") val currency: String,
    @SerializedName("status") val status: String,
    @SerializedName("notes") val notes: Map<String, String>
)
