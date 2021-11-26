package com.sample.content

import androidx.compose.runtime.Composable
import com.sample.articles.Article
import com.sample.articles.*
import com.sample.function.MarkdownReader
import com.sample.style.MarkdownStyle
import com.sample.style.WtCards
import com.sample.style.WtOffsets
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.H1
import org.jetbrains.compose.web.dom.Text


@Composable
fun Articles() {
    val markdownReader = MarkdownReader()
    articles.forEach { article ->
        val markdown = markdownReader.read(article.body)
            markdown(article.date,markdown)
    }
}

val articles : List<Article> = listOf(
    article20211121,
    article20211123,
    article20211125,
)