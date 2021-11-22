package com.sample.function

import com.sample.content.Markdown
import com.sample.content.MarkdownContent
import com.sample.content.Paragraph

class MarkdownReader {

    fun read(markdown: String): Markdown {

        val nodes = lexyer(markdown)
        val markdownContents = parse(nodes)
        return Markdown(title = "test", childContents = markdownContents)
    }

    fun lexyer(markdown: String): List<Node> {
        return markdown.split("\r\n|\r|\n").map {
            Node(
                type = "H1",
                value = it,
            )
        }.toList()
    }

    fun parse(nodes: List<Node>): List<MarkdownContent> {
        return nodes.map {
            Paragraph(
                level = "1",
                title = it.value
            )
        }
    }
}

data class Node(
    val type: String,
    val value: String
)