package com.example.apiconnect

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.apiconnect.ViewModel.MainActivityViewModel
import com.example.apiconnect.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]
        observe()
        viewModel.getCoinPrice()
        binding.apply {
            reloadButton.setOnClickListener {
                viewModel.getCoinPrice()
            }
        }
        setContentView(binding.root)
    }

    private fun observe() {
        viewModel.coinData.observe(this) {
            binding.apply {
                btcPrice.text = it["binance-bitcoin"]?.get("usd").toString()
                ethPrice.text = it["ethereum"]?.get("usd").toString()
                adaPrice.text = it["cardano"]?.get("usd").toString()
            }
        }
    }
}