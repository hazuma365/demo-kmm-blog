package com.sample.articles

val article20211121 =
    Article(
        title = "2021-11-22",
        categories = listOf("blog", "kotlin"),
        date = "2021-11-22",
        body = """
# 20211121
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