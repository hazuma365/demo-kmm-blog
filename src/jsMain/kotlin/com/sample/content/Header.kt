package com.sample.content

import androidx.compose.runtime.Composable
import com.sample.style.*
import com.sample.style.WtCols
import org.jetbrains.compose.web.attributes.ATarget
import org.jetbrains.compose.web.attributes.target
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*
import kotlinx.browser.window

@Composable
fun Header() {
    Section(attrs = {
        classes(WtSections.wtSectionBgWhite)
    }) {
        Div({
            classes(WtCols.wtProfile)
        }) {

        }
    }
}