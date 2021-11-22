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

    val wtH2 by style {
        color(Color("#27282c"))
        fontSize(35.px)
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

    val wtH3 by style {
        color(Color("#27282c"))
        fontSize(30.px)
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

    val wtH4 by style {
        color(Color("#27282c"))
        fontSize(25.px)
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

    val wtH5 by style {
        color(Color("#27282c"))
        fontSize(25.px)
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

    val wtH6 by style {
        color(Color("#27282c"))
        fontSize(25.px)
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

}
