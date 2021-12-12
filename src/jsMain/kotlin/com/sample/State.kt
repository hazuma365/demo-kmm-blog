package com.sample

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.sample.data.Article

var articles: List<Article> by mutableStateOf(listOf())