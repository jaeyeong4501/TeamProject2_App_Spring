package com.example.androidscaffolding.ui.Main.MyPage.Network

import android.app.Application
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MyApplication : Application() {

    //10.100.104.18
    val BASE_URL = "http://10.100.104.18:8083/"
    // 레스트 통신 테스트 샘플
    // spring 서버 레스트 용.
//    val BASE_URL_SPRING_SHOP = "http://10.100.104.27:80/"
//    // spring 서버 레스트 용.
//    var networkServiceSpringShop: INetworkServiceSpringShop
//    // spring 서버 레스트 용.
//    val retrofitSpring: Retrofit
//        get() = Retrofit.Builder()
//            .baseUrl(BASE_URL_SPRING_SHOP)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()

    //add....................................
    var networkService: INetworkService
    val retrofit: Retrofit
        get() = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    init {
        networkService = retrofit.create(INetworkService::class.java)
        // spring 서버 레스트 용.
//        networkServiceSpringShop = retrofitSpring.create(INetworkServiceSpringShop::class.java)
    }

}