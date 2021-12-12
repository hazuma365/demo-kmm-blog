package com.sample.content

import com.sample.data.Article

val article20211121 =
    Article(
        title = "Markdown検証ページ",
        categories = listOf("test"),
        date = "2000-01-01",
        body = """
テスト投稿
# H1
## H2
### H3
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
