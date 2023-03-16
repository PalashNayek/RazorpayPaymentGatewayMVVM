package com.example.razorpaypaymentgatewaymvvm.repositories

import com.example.razorpaypaymentgatewaymvvm.api.RazorpayApiService
import com.example.razorpaypaymentgatewaymvvm.models.CreateOrderRequest
import com.example.razorpaypaymentgatewaymvvm.models.CreateOrderResponse
import javax.inject.Inject

class RazorpayRepository @Inject constructor(private val apiService: RazorpayApiService) {

    suspend fun createOrder(amount: Int, notes: Map<String, String>): CreateOrderResponse {
        val request = CreateOrderRequest(amount = amount, notes = notes)
        return apiService.createOrder(request)
    }
}