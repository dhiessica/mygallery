package br.com.dhmoreira.mygallery.model

import com.squareup.moshi.Json
data class Response(
    @field:Json(name = "data")
    val data: List<Post>
)

data class Post(
    @field:Json(name = "images")
    var imagesDetail : List<Image>
)
data class Image(
    @field:Json(name = "link")
    val link : String,
    @field:Json(name = "description")
    val description : String
)