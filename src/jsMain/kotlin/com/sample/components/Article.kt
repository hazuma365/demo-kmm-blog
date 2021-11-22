package com.sample.components

import androidx.compose.runtime.Composable
import com.sample.style.WtCards
import com.sample.style.WtCols
import com.sample.style.WtOffsets
import com.sample.style.WtTexts
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.H3
import org.jetbrains.compose.web.dom.Text

@Composable
fun Article(
    title: String,
    createDate:String,
    tags: List<String>,
    content: String,
    darkTheme: Boolean = false,
    wtExtraStyleClasses: List<String> = listOf(WtCols.wtCol6, WtCols.wtColMd6, WtCols.wtColSm12),
)  {
    Div({
        classes(WtCards.wtCard, WtOffsets.wtTopOffset24, *wtExtraStyleClasses.toTypedArray())
        classes(if (darkTheme) WtCards.wtCardThemeDark else WtCards.wtCardThemeLight)
    }) {
        Div({
            classes(WtCards.wtCardSection, WtCards.wtVerticalFlex)
        }) {

            Div({ classes(WtCards.wtVerticalFlexGrow) }) {
                ArticleTitle(title = title, darkTheme = darkTheme)
                Text(content)
            }
        }
    }
}

@Composable
private fun ArticleTitle(title: String, darkTheme: Boolean = false) {
    H3({
        classes(WtTexts.wtH3)
        if (darkTheme) {
            classes(WtTexts.wtH3ThemeDark)
        }
    }) {
        Text(title)
    }
}