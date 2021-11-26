package com.sample.style
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.css.selectors.hover

object MarkdownStyle : StyleSheet(AppStylesheet) {

    val wtH1 by style {
        color(Color("#27282c"))
        fontSize(40.px)
        fontSize(AppCSSVariables.wtH2FontSize.value(31.px))
        letterSpacing((-.5).px)
        fontWeight(700)
        lineHeight(40.px)
        lineHeight(40.px)

        media(mediaMaxWidth(640.px)) {
            self style {
                AppCSSVariables.wtH2FontSize(24.px)
                AppCSSVariables.wtH2LineHeight(32.px)
            }
        }

        property(
            "font-family",
            "Gotham SSm A,Gotham SSm B,system-ui,-apple-system,BlinkMacSystemFont,Segoe UI,Roboto,Oxygen,Ubuntu,Cantarell,Droid Sans,Helvetica Neue,Arial,sans-serif"
        )
    }

    val wtSubtitle by style {
        color(Color("#27282c"))
        fontSize(28.px)
        fontSize(AppCSSVariables.wtSubtitle2FontSize.value(28.px))
        letterSpacing("normal")
        fontWeight(300)
        lineHeight(40.px)
        lineHeight(AppCSSVariables.wtSubtitle2LineHeight.value(40.px))

        media(mediaMaxWidth(640.px)) {
            self style {
                AppCSSVariables.wtSubtitle2FontSize(24.px)
                AppCSSVariables.wtSubtitle2LineHeight(32.px)
            }
        }

        property(
            "font-family",
            "Gotham SSm A,Gotham SSm B,system-ui,-apple-system,BlinkMacSystemFont,Segoe UI,Roboto,Oxygen,Ubuntu,Cantarell,Droid Sans,Helvetica Neue,Arial,sans-serif"
        )
    }

}
