package com.sample.content

import com.sample.data.Article

val article20200112 =
    Article(
        title = "記事をTagで管理できるようにした",
        categories = listOf("blog"),
        date = "2021-12-12",
        body = """

記事検索機能が必要だと思い追加。
記事に付与しているメタ情報からタグを生成できるようにした。タグはボタンとして構築されており、タグを押下すると、該当タグに分類するページを表示する。
ページ遷移としてではなく、JavaScriptでページを再レンダリングすることで実現している。
ルーティングは今のJetpack Compose For Webにはないようだ。

    """.trimIndent()
    )
