package com.example.apiconnect.ViewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apiconnect.Retrofit.CoinPriceAPI
import com.example.apiconnect.Retrofit.RetrofitHelper
import kotlinx.coroutines.launch

class MainActivityViewModel : ViewModel() {
    private var _coinData = MutableLiveData<Map<String, Map<String, Double>>>()
    val coinData: MutableLiveData<Map<String, Map<String, Double>>> = _coinData

    fun getCoinPrice() {
        val coinName = "binance-bitcoin,ethereum,cardano"
        val vsCurrency = "usd"
        val coinApi = RetrofitHelper.getInstance().create(CoinPriceAPI::class.java)
        viewModelScope.launch {
            try {
                val response = coinApi.getCoinPrice(coinName, vsCurrency)
                if (response.isSuccessful) {
                    val result = response.body()
                    _coinData.postValue(result)
                } else {
                    Log.d("API Error", response.body().toString())
                }
            } catch (e: Exception) {
                //Handle exception
            }
        }
    }
}