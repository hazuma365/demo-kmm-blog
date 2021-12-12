package com.sample.content

import com.sample.data.Article

val article20200106 =
    Article(
        title = "AWS Amplifyを使う",
        categories = listOf("blog", "aws"),
        date = "2021-12-06",
        body = """

Java
- https://docs.aws.amazon.com/ja_jp/corretto/latest/corretto-11-ug/generic-linux-install.html
```yaml
version: 1
frontend:
  phases:
    # IMPORTANT - Please verify your build commands
    preBuild:
      commands:
      - rpm --import https://yum.corretto.aws/corretto.key
      - curl -L -o /etc/yum.repos.d/corretto.repo https://yum.corretto.aws/corretto.repo
      - yum install -y java-11-amazon-corretto
    build:
      commands:
      - ./gradlew jsBrowserProductionWebpack
      - ls
  artifacts:
    # IMPORTANT - Please verify your build output directory
    files:
      - '**/*'
    baseDirectory: /
  cache:
    paths: []
```
    """.trimIndent()
    )
