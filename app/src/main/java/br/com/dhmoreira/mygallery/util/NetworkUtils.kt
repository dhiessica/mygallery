package br.com.dhmoreira.mygallery.util

import br.com.dhmoreira.mygallery.network.OAuthInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class NetworkUtils {
    companion object{
        fun getRetrofitInstance(path:String, okHttpClient: OkHttpClient) : Retrofit{
            return Retrofit.Builder()
                .baseUrl(path)
                .addConverterFactory(MoshiConverterFactory.create())
                .client(okHttpClient)
                .build()
        }

        fun providesOKHttpClient() : OkHttpClient{
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            return OkHttpClient.Builder().addInterceptor(
                OAuthInterceptor(
                    ConstantsUtils.TOKEN_TYPE,
                    ConstantsUtils.TOKEN
                )
            ).addInterceptor(interceptor).build()
        }
    }
}