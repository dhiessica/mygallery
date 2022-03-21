package br.com.dhmoreira.mygallery

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.dhmoreira.mygallery.network.apiService
import br.com.dhmoreira.mygallery.ui.theme.MyGalleryTheme
import br.com.dhmoreira.mygallery.view.MainScreen
import br.com.dhmoreira.mygallery.viewmodel.MainViewModel

class MainActivity : ComponentActivity() {

    private val mainViewModel by viewModels<MainViewModel>{
        object : ViewModelProvider.Factory{
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return MainViewModel(apiService) as T
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyGalleryTheme {
                Surface(color = MaterialTheme.colors.background) {

                    mainViewModel.getImages()
                    Log.e("TESTE MAIN ACTIVITY", mainViewModel.imageList.toString())
                    
                    MainScreen(mainViewModel)

                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyGalleryTheme {
    }
}