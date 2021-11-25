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
    val childContents: List<MarkdownContent>,
)

data class HeaderContent(
    val level: String,
    val title: String,
) : MarkdownContent {

    @Composable
    override fun render() {
        when (level) {
            "1" -> H1(attrs = { classes(MarkdownStyle.wtH1) }) {
                Text(title)
            }
            "2" -> H2(attrs = { classes(MarkdownStyle.wtH2) }) {
                Text(title)
            }
            "3" -> H3(attrs = { classes(MarkdownStyle.wtH3) }) {
                Text(title)
            }
            "4" -> H4(attrs = { classes(MarkdownStyle.wtH4) }) {
                Text(title)
            }
            "5" -> H5(attrs = { classes(MarkdownStyle.wtH5) }) {
                Text(title)
            }
            "6" -> H6(attrs = { classes(MarkdownStyle.wtH6) }) {
                Text(title)
            }
        }
    }
}

data class Paragraph(
    val childMarkdownContents: List<MarkdownContent>
) : MarkdownContent {

    @Composable
    override fun render() {
        childMarkdownContents.forEach { it.render() }
        Br()
    }
}


data class UnorderedList(
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

data class OrderedList(
    val childMarkdownContents: List<MarkdownContent>
) : MarkdownContent {

    @Composable
    override fun render() {
        Ol() {
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

data class TextAndBrContent(
    val text: String
) : MarkdownContent {

    @Composable
    override fun render() {
        Text(text)
        Br()
    }
}

data class BrContent(
    val text: String
) : MarkdownContent {

    @Composable
    override fun render() {
        Br()
    }
}

data class CodeBlock(
    val language: String,
    val code: String,
) : MarkdownContent {

    @Composable
    override fun render() {
        Div({
            classes(WtOffsets.wtTopOffset24)
            style {
                backgroundColor(rgba(39, 40, 44, 0.05))
                borderRadius(8.px, 8.px, 8.px)
                padding(12.px, 16.px)
            }
        }) {
            FormattedCodeSnippet(code = code, language = language)
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