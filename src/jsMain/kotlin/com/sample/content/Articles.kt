package com.sample.content

import androidx.compose.runtime.Composable
import com.sample.components.markdown
import com.sample.function.MarkdownReader
import com.sample.repository.ArticleRepository
import com.sample.style.WtCols
import com.sample.style.WtOffsets
import com.sample.style.WtSections
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Section

val articleRepository = ArticleRepository()

@Composable
fun Articles() {
    val markdownReader = MarkdownReader()
    articleRepository.getAll().sortedByDescending { it.date }.forEach { article ->
        Div({
            classes(WtSections.wtSectionBgWhite, WtOffsets.wtTopOffset24, WtOffsets.wtBottomOffset24)
        }) {
            val markdown = markdownReader.read(article.body)
            markdown(article.date, markdown)
        }
    }
}