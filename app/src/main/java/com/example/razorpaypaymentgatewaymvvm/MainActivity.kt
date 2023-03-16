package com.example.razorpaypaymentgatewaymvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.razorpaypaymentgatewaymvvm.models.CreateOrderResponse
import com.example.razorpaypaymentgatewaymvvm.viewmodels.PaymentViewModel
import com.razorpay.Checkout
import dagger.hilt.android.AndroidEntryPoint
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}