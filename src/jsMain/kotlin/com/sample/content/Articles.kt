package com.sample.content

import androidx.compose.runtime.Composable
import com.sample.articles.Article
import com.sample.articles.*
import com.sample.function.MarkdownReader


@Composable
fun Articles() {
    val markdownReader = MarkdownReader()
    articles.forEach { article ->
        val markdown = markdownReader.read(article.body)
        markdown(markdown)
    }
}

val articles : List<Article> = listOf(
    article20211121,
    article20211122,
)