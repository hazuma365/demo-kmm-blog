package com.sample.repository

import com.sample.data.Article
import com.sample.content.article20211121
import com.sample.content.article20211123
import com.sample.content.article20211125

class ArticleRepository {

    fun getAll(): List<Article> {
        return listOf(
            article20211121,
            article20211123,
            article20211125,
        )
    }
}