package br.com.dhmoreira.mygallery.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import br.com.dhmoreira.mygallery.R
import br.com.dhmoreira.mygallery.model.Image
import br.com.dhmoreira.mygallery.viewmodel.MainViewModel
import coil.compose.rememberImagePainter
import coil.size.Scale
import coil.transform.CircleCropTransformation

@Composable
fun MainScreen(mainViewModel: MainViewModel){
    Column (){
        Toolbar(stringResource(id = R.string.page_title_home))
        ImageList(mainViewModel = mainViewModel)
    }
}

@Composable
fun Toolbar(screenTitle : String){
    TopAppBar (
        title = {
            Text(text = screenTitle, color = Color.White)
        },
        backgroundColor = Color.DarkGray
    )
}

@Composable
fun ImageList(mainViewModel: MainViewModel){

    LazyColumn{
        itemsIndexed(items = mainViewModel.imageList) { _, item ->
            ImageItem(image = item)
        }
    }
}

@Composable
fun ImageItem(image: Image) {
    Card(
        modifier = Modifier
            .padding(8.dp, 4.dp)
            .fillMaxWidth()
            .height(300.dp), shape = RoundedCornerShape(8.dp), elevation = 4.dp
    ){
        Surface() {
            Row(
                Modifier
                    .padding(4.dp)
                    .fillMaxSize()
            ) {
                Image(
                    painter = rememberImagePainter(
                        data = image.link),
                    contentDescription = "Cat Images",
                    modifier = Modifier
                        .fillMaxSize(),
                    contentScale = ContentScale.Crop

                )
            }

        }
    }
}