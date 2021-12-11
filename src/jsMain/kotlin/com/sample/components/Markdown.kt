package com.sample.components

import androidx.compose.runtime.Composable
import com.sample.style.*
import org.jetbrains.compose.web.dom.*

interface MarkdownContent {
    @Composable
    open fun render()
}

@Composable
fun markdown(
    title: String,
    markdown: Markdown,
) {
    Div({
        classes(WtCols.wtArticle)
    }) {
        H1(attrs = { classes(MarkdownStyle.wtH1) }) {
            Text(title)
        }
        markdown.childContents.forEach { child ->
            child.render()
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
            "1" -> H1(attrs = { classes(MarkdownStyle.wtSubtitle) }) {
                Text(title)
            }
            "2" -> H2(attrs = { classes(MarkdownStyle.wtSubtitle) }) {
                Text(title)
            }
            "3" -> H3(attrs = { classes(MarkdownStyle.wtSubtitle) }) {
                Text(title)
            }
            "4" -> H4(attrs = { classes(MarkdownStyle.wtSubtitle) }) {
                Text(title)
            }
            "5" -> H5(attrs = { classes(MarkdownStyle.wtSubtitle) }) {
                Text(title)
            }
            "6" -> H6(attrs = { classes(MarkdownStyle.wtSubtitle) }) {
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
        FormattedCodeSnippet(code = code, language = language)
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