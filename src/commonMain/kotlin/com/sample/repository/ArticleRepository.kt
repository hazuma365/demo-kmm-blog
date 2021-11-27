package com.sample.repository

import com.sample.data.Article
import com.sample.content.article20211121
import com.sample.content.article20211123
import com.sample.content.article20211125
import com.sample.content.articleList

class ArticleRepository {

    fun getAll(): List<Article> {
        return articleList
    }
}