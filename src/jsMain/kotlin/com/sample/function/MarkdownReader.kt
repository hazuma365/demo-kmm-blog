package com.sample.function

import com.sample.content.*
import org.intellij.markdown.IElementType
import org.intellij.markdown.MarkdownElementTypes
import org.intellij.markdown.MarkdownTokenTypes
import org.intellij.markdown.ast.ASTNode
import org.intellij.markdown.ast.getTextInNode
import org.intellij.markdown.flavours.gfm.GFMFlavourDescriptor
import org.intellij.markdown.parser.MarkdownParser

class MarkdownReader {
    fun read(markdown: String): Markdown {
        val flavour = GFMFlavourDescriptor()
        val parsedTree = MarkdownParser(flavour).buildMarkdownTreeFromString(markdown)
        val markdownContents = mutableListOf<MarkdownContent>()
        parsedTree.children.forEach { astNode ->
            markdownContents.add(
                astNode.parse(markdown)
            )
            // debug
            //debug(astNode, markdown, markdownContents)
        }
        return Markdown(childContents = markdownContents)
    }

    private fun debug(
        astNode: ASTNode,
        markdown: String,
        markdownContents: MutableList<MarkdownContent>
    ) {
        TextAndBrContent("parents:" + astNode.type.name + ":" + astNode.getTextInNode(markdown).toString())
        astNode.children.forEach {
            markdownContents.add(
                TextAndBrContent("child:" + it.type.name + ":" + it.getTextInNode(markdown).toString())
            )
        }
    }
}

private fun ASTNode.parse(content: String): MarkdownContent {
    val value = this.getTextInNode(content).toString()
    return when (type) {
        MarkdownElementTypes.PARAGRAPH -> buildParagraph(this, content)
        MarkdownElementTypes.ATX_1 -> buildHeader(this, content)
        MarkdownElementTypes.ATX_2 -> buildHeader(this, content)
        MarkdownElementTypes.ATX_3 -> buildHeader(this, content)
        MarkdownElementTypes.ATX_4 -> buildHeader(this, content)
        MarkdownElementTypes.ATX_5 -> buildHeader(this, content)
        MarkdownElementTypes.ATX_6 -> buildHeader(this, content)
        MarkdownElementTypes.CODE_FENCE -> buildeCodeBlock(this, content)
        MarkdownElementTypes.UNORDERED_LIST -> buildUnorderedList(this, content)
        MarkdownElementTypes.ORDERED_LIST -> buildOrderedList(this, content)
        MarkdownTokenTypes.EOL -> BrContent("")
        else -> TextAndBrContent("debug:" + this.type.name + ":" + value)
    }
}

fun buildeCodeBlock(astNode: ASTNode, content: String): MarkdownContent {
    val title = astNode.findChildOfTypeRecursive(MarkdownTokenTypes.FENCE_LANG)?.getTextInNode(content).toString()

    val code = astNode.findChildrenOfTypeRecursive(MarkdownTokenTypes.CODE_FENCE_CONTENT)?.map {
        it.getTextInNode(content).toString()
    }.joinToString("\n")

    return CodeBlock(
        language = title,
        code = code
    )
}

fun buildParagraph(node: ASTNode, content: String): MarkdownContent {
    val childMarkdownContents = node.children.map {
        when (it.type) {
            MarkdownTokenTypes.EOL -> BrContent("")
            MarkdownTokenTypes.TEXT -> TextContent(it.getTextInNode(content).toString())
            else -> TextContent("debug:" + it.type.name + ":" + it.getTextInNode(content).toString())
        }
    }.toList()
    return Paragraph(childMarkdownContents = childMarkdownContents)
}

fun buildHeader(astNode: ASTNode, content: String): MarkdownContent {
    return HeaderContent(
        level = "1",
        title = astNode.findChildOfTypeRecursive(MarkdownTokenTypes.ATX_CONTENT)?.getTextInNode(content).toString()
    )
}

fun buildUnorderedList(node: ASTNode, content: String): MarkdownContent {
    val childMarkdownContents =
        node.findChildrenOfTypeRecursive(MarkdownElementTypes.LIST_ITEM)?.map {
            TextContent(it.getTextInNode(content).toString())
        }

    return UnorderedList(childMarkdownContents)
}

fun buildOrderedList(node: ASTNode, content: String): MarkdownContent {
    val childMarkdownContents =
        node.findChildrenOfTypeRecursive(MarkdownElementTypes.LIST_ITEM)?.map {
            TextContent(it.getTextInNode(content).toString())
        }
    return OrderedList(childMarkdownContents)
}


/**
 * Find a child node recursive
 */
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

/**
 * Find a child node recursive
 */
fun ASTNode.findChildrenOfTypeRecursive(type: IElementType): List<ASTNode> {
    return children.filter {
        it.type == type
    }.toList()
}