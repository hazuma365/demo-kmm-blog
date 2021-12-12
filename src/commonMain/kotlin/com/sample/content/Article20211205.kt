package com.sample.content

import com.sample.data.Article

val article20200105 =
    Article(
        title = "レスポンシブデザインにはまる",
        categories = listOf("blog"),
        date = "2021-12-05",
        body = """

WEBサイトベースでつくっていたため、SPで見るとずれることが判明。
適当にDIVなどを組み合わせてきたが、大幅な工事が必要そう。

    """.trimIndent()
    )
