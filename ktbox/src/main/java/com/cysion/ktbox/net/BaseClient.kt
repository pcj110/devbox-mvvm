package com.cysion.ktbox.net

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit

/**
 * 保证项目仅持有一份okhttp和retrofit的底层资源，不可直接使用；
 * 网络请求参考BaseCaller
 */

object BaseClient {

    val mOkHttpClient by lazy {
        OkHttpClient.Builder()
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .connectTimeout(30, TimeUnit.SECONDS)
            .build()
    }

    val mRetrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://www.xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.com/")
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(mOkHttpClient)
            .build()
    }

}