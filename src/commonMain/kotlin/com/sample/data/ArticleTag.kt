package com.sample.data

data class ArticleTag(
    val name: String,
    val articleTagType: ArticleTagType,
    val count: Int,
)

enum class ArticleTagType{
    YEAR_MONTH,
    CATEGORY,
}
