package com.sample.content

import androidx.compose.runtime.Composable
import com.sample.style.*
import com.sample.style.WtCols
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*

@Composable
fun Header() {
    Section(attrs = {
        classes(WtSections.wtSectionBgWhite, WtOffsets.wtTopOffset24)
    }) {
        Div({ classes(WtContainer.wtContainer) }) {
            Div({
                classes(WtCols.wtProfile)
            }) {
                Img(src = "icon.svg", attrs = {
                    style {
                        width(120.px)
                        height(120.px)
                        borderRadius(50.percent)
                        border(10.px, LineStyle.Solid)
                    }
                })
                H1(attrs = { classes(MarkdownStyle.wtH1) }) {
                    Text("あれやこれや")
                }
            }
        }
    }
}