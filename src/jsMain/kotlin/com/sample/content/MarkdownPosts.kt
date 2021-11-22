package com.sample.content

val markdownText = Markdown(
    title = "2021-11-20",
    childContents = listOf(
        Paragraph(
            level = "1",
            title = "H1-Text",
        ),
        TextContent("H2-text"),
        Paragraph(
            level = "2",
            title = "H2-itemList",
        ),
        ItemList(
            listOf(
                TextContent("item-1"),
                TextContent("item-2"),
                TextContent("item-3"),
                ItemList(
                    listOf(
                        TextContent("item-1-1"),
                        TextContent("item-1-2"),
                        TextContent("item-1-3"),
                    )
                ),
            )
        ),
        Paragraph(
            level = "3",
            title = "H3",
        ),
        TextContent("H2-text"),
        Code("code", "puts 'The best way to log and share programmers knowledge.'")
    )
)