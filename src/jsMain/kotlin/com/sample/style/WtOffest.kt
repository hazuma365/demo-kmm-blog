package com.sample.style
import org.jetbrains.compose.web.css.*

object WtOffsets : StyleSheet(AppStylesheet) {
    val wtTopOffset96 by style {
        marginTop(96.px)
        property(
            "margin-top",
            "calc(4*${AppCSSVariables.wtOffsetTopUnit.value(24.px)})"
        )
    }

    val wtTopOffset24 by style {
        marginTop(24.px)
        property(
            "margin-top",
            "calc(1*${AppCSSVariables.wtOffsetTopUnit.value(24.px)})"
        )
    }

    val wtBottomOffset24 by style {
        marginBottom(24.px)
        property(
            "margin-bottom",
            "calc(1*${AppCSSVariables.wtOffsetTopUnit.value(24.px)})"
        )
    }



    val wtTopOffset48 by style {
        marginTop(48.px)
    }
}
