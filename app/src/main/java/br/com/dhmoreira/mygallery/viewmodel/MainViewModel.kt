package br.com.dhmoreira.mygallery.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.dhmoreira.mygallery.model.Image
import br.com.dhmoreira.mygallery.model.Post
import br.com.dhmoreira.mygallery.network.ApiService
import kotlinx.coroutines.launch

class MainViewModel(private val apiService: ApiService) : ViewModel(){

    var imageList:List<Image> by mutableStateOf(listOf())

    fun getImages(){
        viewModelScope.launch {
            try {
                var  list : List<Image> by mutableStateOf(listOf())
                val response = apiService.getImages()
                for(post in response.data){
                    list = list + post.imagesDetail
                }
                imageList = list

            }catch (e:Exception){
                Log.e("Service Error", e.toString())

            }
        }
    }

}