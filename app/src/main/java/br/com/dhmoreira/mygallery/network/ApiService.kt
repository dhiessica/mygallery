package br.com.dhmoreira.mygallery.network

import br.com.dhmoreira.mygallery.model.Response
import br.com.dhmoreira.mygallery.util.ConstantsUtils
import br.com.dhmoreira.mygallery.util.NetworkUtils
import retrofit2.http.GET

interface ApiService {
    @GET(ConstantsUtils.CAT_ROUTE)
    suspend fun getImages() : Response
}

val retrofit = NetworkUtils.getRetrofitInstance(
    ConstantsUtils.BASE_URL,
    NetworkUtils.providesOKHttpClient()
)
val apiService = retrofit.create(ApiService::class.java)