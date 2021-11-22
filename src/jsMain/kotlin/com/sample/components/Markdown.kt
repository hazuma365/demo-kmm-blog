package com.sample.content

import androidx.compose.runtime.Composable
import com.sample.style.*
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*

interface MarkdownContent {
    @Composable
    open fun render()
}

@Composable
fun markdown(
    markdown: Markdown,
    darkTheme: Boolean = false,
    wtExtraStyleClasses: List<String> = listOf(WtCols.wtCol6, WtCols.wtColMd6, WtCols.wtColSm12)
) {
    Div({
        classes(WtCards.wtCard, WtOffsets.wtTopOffset24, *wtExtraStyleClasses.toTypedArray())
        classes(if (darkTheme) WtCards.wtCardThemeDark else WtCards.wtCardThemeLight)
    }) {
        H1(attrs = { classes(WtTexts.wtSubtitle2) }) {
            Text(markdown.title)
        }

        Div({
            classes(WtCards.wtCardSection, WtCards.wtVerticalFlex)
        }) {
            markdown.childContents.forEach { child ->
                child.render()
            }
        }
    }
}

data class Markdown(
    val title: String,
    val childContents: List<MarkdownContent>,
)

data class Paragraph(
    val level: String,
    val title: String,
) : MarkdownContent {

    @Composable
    override fun render() {
        H1(attrs = { classes(MarkdownStyle.wtH1) }) {
            Text(title)
        }
    }
}

data class ItemList(
    val childMarkdownContents: List<MarkdownContent>
) : MarkdownContent {

    @Composable
    override fun render() {
        Ul() {
            childMarkdownContents.forEach { child ->
                Li() {
                    child.render()
                }
            }
        }
    }
}

data class TextContent(
    val text: String
) : MarkdownContent {

    @Composable
    override fun render() {
        Text(text)
    }
}

data class Code(
    val title: String,
    val code: String,
) : MarkdownContent {

    @Composable
    override fun render() {
        H3({
            classes(WtTexts.wtH3, WtOffsets.wtTopOffset48)
        }) {
            Text(title)
        }

        Div({
            classes(WtOffsets.wtTopOffset24)
            style {
                backgroundColor(rgba(39, 40, 44, 0.05))
                borderRadius(8.px, 8.px, 8.px)
                padding(12.px, 16.px)
            }
        }) {
            FormattedCodeSnippet(code = code)
        }
    }
}

data class Link(
    val title: String,
    val url: String,
) : MarkdownContent {

    @Composable
    override fun render() {
        Text("$title:$url")
    }
}