package com.example.razorpaypaymentgatewaymvvm.api

import com.example.razorpaypaymentgatewaymvvm.models.CreateOrderRequest
import com.example.razorpaypaymentgatewaymvvm.models.CreateOrderResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface RazorpayApiService {
    @POST("payments")
    suspend fun createOrder(@Body body: CreateOrderRequest): CreateOrderResponse
}