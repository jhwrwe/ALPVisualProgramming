package com.example.alpvisualprogramming.repositories

import com.example.alpvisualprogramming.services.MyDBService
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AuthInterceptor(private val bearerToken: String) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): okhttp3.Response {
        val originalRequest = chain.request()
        val request = originalRequest.newBuilder()
            .header("Authorization", "Bearer $bearerToken")
            .build()
        return chain.proceed(request)
    }
}
class MyDBContainer (){
    companion object  {
        val BASE_IMG = ""
        var ACCESS_TOKEN =""
    }

    private val BASE_URL = "https://192.168.102.156/VP_Week8_2023/VisProg_VsCodea/week8_vp/public/api"

    private val client = OkHttpClient.Builder()
        .addInterceptor(AuthInterceptor(ACCESS_TOKEN))
        .build()

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .client(client)
        .build()
    private val retrofitservice : MyDBService by lazy {
        retrofit.create(MyDBService::class.java)
    }
    val myDBRepositories:MyDBRepositories by lazy {
        MyDBRepositories(retrofitservice)
    }
}