package com.sample.content

import androidx.compose.runtime.Composable
import com.sample.articles
import com.sample.style.*
import com.sample.style.WtCols
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*

@Composable
fun TagArea() {
    val categories = articleRepository.getAllTag()

    Section(attrs = {
        classes(WtSections.wtSectionBgWhite)
    }) {
        Div({
            classes(WtCols.wtCategory)
        }) {
            categories.forEach { category ->
                Button(attrs = {
                    onClick {
                        articles = articleRepository.findBy(
                            category.articleTagType, category.name
                        )
                    }
                    style {
                        borderRadius(100.vh)
                    }
                }) {
                    Text(category.name + "(" + category.count + ")")
                }
            }
        }

    }
}