package com.sample.content

import androidx.compose.runtime.Composable
import com.sample.articles
import com.sample.data.ArticleTagType
import com.sample.style.WtCols
import com.sample.style.WtSections
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*

@Composable
fun TagArea() {
    Section(attrs = {
        classes(WtSections.wtSectionBgWhite, WtCols.wtCategory)
    }) {
        Div({
            style {
                paddingBottom(4.px)
                paddingTop(4.px)
            }
        }) {
            TagButtons(ArticleTagType.CATEGORY)
            Br()
            TagButtons(ArticleTagType.YEAR_MONTH)
        }
    }
}

@Composable
fun TagButtons(articleTagType: ArticleTagType) {
    val tags = articleRepository.getAllTag()
    tags.filter { it.articleTagType == articleTagType }.forEach { it ->
        TagButton(it.articleTagType, it.name, it.count)
    }
}

@Composable
fun TagButton(articleTagType: ArticleTagType, name: String, count: Int = 0) {
    Button(attrs = {
        onClick {
            articles = articleRepository.findBy(
                articleTagType, name
            )
        }
        style {
            borderRadius(100.vh)
            margin(1.px)
        }
    }) {
        if (count > 0) {
            Text("$name($count)")
        } else {
            Text(name)
        }
    }
}






