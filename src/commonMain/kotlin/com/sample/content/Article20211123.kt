package com.sample.content

import com.sample.data.Article

val article20211123 =
    Article(
        title = "2021-11-23",
        categories = listOf("blog", "kotlin"),
        date = "2021-11-23",
        body = """
# Compose for Web でブログをつくる
# WHY
- フロントエンド技術へのとっかかり。
- ベースがJavaエンジニアなので、WEBサイトを既知の技術の延長でつくれるのはありがたい。
- 格好いい
# ざっくり要件
- PCから、スマフォで見ることができる。
- 記事をマークダウンで投稿することができる。
- 泥臭くてもいいのでまずは動くもの、見せられるものをつくる。
# 技術要素
## フロントエンド
- Compose for Web
- マークダウン読み込み、自作。()
## バックエンド
- AWS Amplify
# フロントエンド
## Compose for Web
## マークダウン読み込み
- Nodeを解析→Data→@Composable に変換という
#### H4
##### H5
###### H6
# Paragraph
text1
text2
# LIST
- Text1
- Text2
# 番号付きリスト
1. Text1
1. Text2
# Code
```java
fun ASTNode.findChildOfTypeRecursive(type: IElementType): ASTNode? {
    children.forEach {
        if (it.type == type) {
            return it
        } else {
            val found = it.findChildOfTypeRecursive(type)
            if (found != null) {
                return found
            }
        }
    }
    return null
}
```
    """.trimIndent()
    )