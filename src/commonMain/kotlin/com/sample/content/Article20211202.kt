package com.sample.content

import com.sample.data.Article

val article20200102 =
    Article(
        title = "ブログのアーキテクチャ",
        categories = listOf("blog"),
        date = "2021-12-02",
        body = """

# Architecture
frontend
- Jetpack Compose For Web
infra
- AWS Amplify
CICD
- GitHub
- Codebuild

# AWS Amplify
カスタマイズしようとすると辛みがますが、仕組みにのっていくなら
AWSの利用感覚を忘れないためというのも大きい。
 
# デプロイパイプライン
1. 人：記事を書く/WEBサイトを改修する
1. 人：GitHub　に記事をPush
1. AWS Codebuild: GitHubへのPUSを検知して Build→ArtifactをS3にアップ
1. AWS Amplify: S3のArtifact をホスティング
    """.trimIndent()
    )
