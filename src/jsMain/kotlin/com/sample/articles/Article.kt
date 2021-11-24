package com.sample.articles

data class Article(
    val title : String,
    val categories : List<String>,
    val date : String,
    val body : String,
)