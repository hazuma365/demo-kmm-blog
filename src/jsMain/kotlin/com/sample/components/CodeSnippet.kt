package com.sample.components

import androidx.compose.runtime.Composable
import com.sample.HighlightJs
import com.sample.style.WtOffsets
import com.sample.style.WtRows
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.css.keywords.auto
import org.jetbrains.compose.web.dom.Code
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Hr
import org.jetbrains.compose.web.dom.Pre
import org.w3c.dom.HTMLElement


@Composable
fun CodeSnippet(code: String, language: String) {
    Div({
        classes(WtRows.wtRow)
        style {
            justifyContent(JustifyContent.SpaceBetween)
        }
    }) {
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

@Composable
fun FormattedCodeSnippet(code: String, language: String = "kotlin") {
    Pre({
        style {
            maxHeight(25.em)
            overflow("auto")
            height(auto)
            marginTop(24.px)
            backgroundColor(rgba(39, 40, 44, 0.05))
            borderRadius(8.px)
            maxWidth(100.percent)
        }
    }) {
        Code({
            classes("language-$language", "hljs")
            style {
                property("font-family", "'JetBrains Mono', monospace")
                property("tab-size", 4)
                fontSize(10.pt)
            }
        }) {
            DomSideEffect(code) {
                it.setHighlightedCode(code)
            }
        }
    }
}

private fun HTMLElement.setHighlightedCode(code: String) {
    innerText = code
    HighlightJs.highlightElement(this)
}