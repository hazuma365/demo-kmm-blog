package com.sample.content

import androidx.compose.runtime.Composable
import com.sample.function.MarkdownReader
import com.sample.repository.ArticleRepository

val articleRepository = ArticleRepository()

@Composable
fun Articles() {
    val markdownReader = MarkdownReader()
    articleRepository.getAll().forEach { article ->
        val markdown = markdownReader.read(article.body)
        markdown(article.date, markdown)
    }
}