package com.sample

import org.jetbrains.compose.web.css.Style
import org.jetbrains.compose.web.renderComposable
import com.sample.components.Layout
import com.sample.components.MainContentLayout
import com.sample.content.*
import com.sample.style.AppStylesheet

fun main() {
    renderComposable(rootElementId = "root") {
        Style(AppStylesheet)
        Layout {
            Header()
            Categories()
            MainContentLayout() { MainArea() }
            PageFooter()
        }
    }
}