package com.sample.repository

import com.sample.data.Article
import com.sample.content.articleList
import com.sample.data.ArticleTagType
import com.sample.data.ArticleTag

class ArticleRepository {

    fun getAll(): List<Article> {
        return articleList
    }

    fun getAllTag(): List<ArticleTag> {
        return getAllTagByCategory() + getAllCategoryByMonth()
    }

    fun getAllTagByCategory(): List<ArticleTag> {
        return articleList.flatMap { it.categories }.toList().groupBy { it }.map {
            ArticleTag(it.key, ArticleTagType.CATEGORY,it.value.size)
        }
    }

    fun getAllCategoryByMonth(): List<ArticleTag> {
        return articleList.groupBy { it.date.substring(0,7) }.map {
            ArticleTag(it.key.substring(0,7), ArticleTagType.YEAR_MONTH,it.value.size)
        }
    }

    fun findByCategory(category: String): List<Article> {
        return articleList.filter { it.categories.contains(category) }.toList()
    }

    fun findByMonth(month: String): List<Article> {
        return articleList.filter { it.date.substring(0,7) == month }.toList()
    }

    fun findBy(articleTagType : ArticleTagType, value: String): List<Article> {
        return when(articleTagType){
            ArticleTagType.CATEGORY -> {findByCategory(value)}
            ArticleTagType.YEAR_MONTH -> {findByMonth(value)}
        }
    }
}