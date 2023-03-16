package com.example.razorpaypaymentgatewaymvvm.models

import com.google.gson.annotations.SerializedName

data class CreateOrderRequest(
    @SerializedName("amount") val amount: Int,
    @SerializedName("currency") val currency: String = "INR",
    @SerializedName("payment_capture") val paymentCapture: Int = 1,
    @SerializedName("notes") val notes: Map<String, String>
)
