package com.example.razorpaypaymentgatewaymvvm.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.razorpaypaymentgatewaymvvm.models.CreateOrderResponse
import com.example.razorpaypaymentgatewaymvvm.repositories.RazorpayRepository
import com.example.razorpaypaymentgatewaymvvm.utils.PaymentState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PaymentViewModel @Inject constructor(
    private val repository: RazorpayRepository
) : ViewModel() {

    private val _paymentState = MutableStateFlow<PaymentState>(PaymentState.Idle)
    val paymentState: StateFlow<PaymentState> = _paymentState

    fun createOrder(amount: Int, notes: Map<String, String>) {
        viewModelScope.launch {
            _paymentState.value = PaymentState.Loading
            try {
                val response = repository.createOrder(amount, notes)
                _paymentState.value = PaymentState.Success(response)
            } catch (e: Exception) {
                _paymentState.value = PaymentState.Error(e)
            }
        }
    }
}
