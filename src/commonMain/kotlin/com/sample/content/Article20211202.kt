package com.sample.content

import com.sample.data.Article

val article20200102 =
    Article(
        title = "2021-12-02",
        categories = listOf("blog"),
        date = "2021-12-02",
        body = """

ブログの構造
- Jetpack Compose For Web を利用する。
- AWS Amplify
# Jetpack Compose For Web を利用する。


# AWS Amplify
カスタマイズしようとすると辛みがますが、仕組みにのっていくなら
AWSの利用感覚を忘れないためというのも大きい。
 
# デプロイパイプライン
1. 人：記事を書く/WEBサイトを改修する
1. 人：GitHub　に記事をPush
1. AWS Codebuild: GitHub 検知して Build
1. AWS Codebuild: Artifact をAWS Amplifyにアップ
    """.trimIndent()
    )
