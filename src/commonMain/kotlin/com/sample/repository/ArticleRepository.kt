package com.sample.repository

import com.sample.data.Article
import com.sample.content.articleList
import com.sample.data.Category

class ArticleRepository {

    fun getAll(): List<Article> {
        return articleList
    }

    fun getAllTags(): List<String> {
        var tagSet = mutableSetOf<String>()
        articleList.forEach { article ->
            article.categories.forEach { category ->
                tagSet.add(category)
            }
        }
        return tagSet.toList()
    }

    fun getAllCategories(): List<Category> {
        val categories = articleList.flatMap { it.categories }.toList().groupBy { it }.map {
            Category(it.key, it.value.size)
        }
        return categories
    }

    fun findOf(category: String): List<Article> {
        return articleList.filter { it.categories.contains(category) }.toList()
    }
}