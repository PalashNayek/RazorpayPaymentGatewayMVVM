package com.example.razorpaypaymentgatewaymvvm.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.Navigation.findNavController
import com.example.razorpaypaymentgatewaymvvm.R
import com.example.razorpaypaymentgatewaymvvm.databinding.FragmentPaymentBinding
import com.example.razorpaypaymentgatewaymvvm.utils.PaymentState
import com.example.razorpaypaymentgatewaymvvm.viewmodels.PaymentViewModel
import com.razorpay.Checkout
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.launch

@AndroidEntryPoint
class PaymentFragment : Fragment() {
    private var _binding : FragmentPaymentBinding?= null
    private val binding get() = _binding!!
    private val paymentViewModel: PaymentViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentPaymentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Log.d("HomeFragment", "This is home fragment")
        val amount = 100 // Replace with actual amount
        val notes = mapOf("orderId" to "123456") // Replace with actual notes

        binding.btnPay.setOnClickListener {
            paymentViewModel.createOrder(amount,notes)
            bindObserver()
        }

        val checkout = Checkout()
        checkout.setKeyID("YOUR_RAZORPAY_KEY")
    }

    private fun bindObserver() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                paymentViewModel.paymentState.collect{
                    binding.progressBar.isVisible = false
                    when(it){
                        is PaymentState.Success ->{
                            /*binding.btnHome.setOnClickListener {
                                findNavController().navigate(R.id.action_homeFragment_to_secondFragment)
                            }*/
                            Toast.makeText(context, "Payment Success", Toast.LENGTH_SHORT).show()
                        }

                        is PaymentState.Error ->{
                            Toast.makeText(context, "Payment Error", Toast.LENGTH_SHORT).show()
                        }

                        is PaymentState.Loading ->{
                            binding.progressBar.isVisible = true
                        }

                        is PaymentState.Idle ->{
                            Toast.makeText(context, "Payment Idle", Toast.LENGTH_SHORT).show()
                        }
                    }

                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}