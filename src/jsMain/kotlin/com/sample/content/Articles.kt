package com.sample.content

import androidx.compose.runtime.Composable
import com.sample.components.markdown
import com.sample.data.Article
import com.sample.data.ArticleTagType
import com.sample.function.MarkdownReader
import com.sample.repository.ArticleRepository
import com.sample.style.MarkdownStyle
import com.sample.style.WtOffsets
import com.sample.style.WtSections
import org.jetbrains.compose.web.css.em
import org.jetbrains.compose.web.css.maxWidth
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.H1
import org.jetbrains.compose.web.dom.Text

val articleRepository = ArticleRepository()
val markdownReader = MarkdownReader()

@Composable
fun Articles(articles: List<Article>) {
    articles.sortedByDescending { it.date }.forEach { article ->
        Article(article)
    }
}

@Composable
fun Article(article: Article) {
    Div({
        classes(WtSections.wtSectionBgWhite, WtOffsets.wtTopOffset24, WtOffsets.wtBottomOffset24)
        style {
            maxWidth(36.em)
        }
    }) {
        Text(article.date)
        H1(attrs = {
            classes(MarkdownStyle.wtH1)
            style {
                maxWidth(36.em)
                property("border-bottom", "1px solid black")
            }
        }) {
            Text(article.title)
        }
        article.categories.forEach {
            TagButton(ArticleTagType.CATEGORY, it)
        }
        markdown(markdownReader.read(article.body))
    }
}