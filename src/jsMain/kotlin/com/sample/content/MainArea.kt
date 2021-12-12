package com.sample.content

import androidx.compose.runtime.Composable
import com.sample.articles
import com.sample.components.ContainerInSection
import com.sample.repository.ArticleRepository
import com.sample.style.*
import com.sample.style.WtCols
import org.jetbrains.compose.web.dom.*

@Composable
fun MainArea() {
    val articleRepository = ArticleRepository()
    articles = articleRepository.getAll()

    ContainerInSection {
        Div(attrs = {
            classes(WtRows.wtRow, WtRows.wtRowSizeM, WtRows.wtRowSmAlignItemsCenter)
        }) {
            Div({ classes(WtContainer.wtContainer) }) {
                Div({
                    classes(
                        WtCols.wtMainArea,
                        WtCols.wtCol10,
                        WtCols.wtColMd8,
                        WtCols.wtColSm12,
                        WtDisplay.wtDisplayMdBlock)
                }) {
                    Articles(articles)
                }
            }
        }
    }
}