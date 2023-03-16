package com.example.razorpaypaymentgatewaymvvm.utils

import com.example.razorpaypaymentgatewaymvvm.models.CreateOrderResponse

sealed class PaymentState {
    object Idle : PaymentState()
    object Loading : PaymentState()
    data class Success(val response: CreateOrderResponse) : PaymentState()
    data class Error(val throwable: Throwable) : PaymentState()
}
