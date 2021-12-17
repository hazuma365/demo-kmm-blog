package com.sample.content

import com.sample.data.Article

val article20200111 =
    Article(
        title = "バックエンドエンジニアがマークアップするときに思ったこと",
        categories = listOf("blog", "poem"),
        date = "2021-12-11",
        body = """

スタイルが異なるように思えた。
- 基礎レベルでは、HTMLやCSS利用への習熟、ブラウザの動作など、技術要素・ライブラリに依った経験・知識が大きい感じる
- 実践レベルではUI・UXなどの
- データフローとアルゴリズムを重視する。
時代の流れが早い、数年単位でFWが変わる。
ブラウザ仕様・Apple・Googleなどの外的環境の影響を受けやすい。
- Markdown->ASTNode->Composable
- Markdown->HTML->Composable(Html) という手段があるように思えて仕方がない。
    """.trimIndent()
    )
