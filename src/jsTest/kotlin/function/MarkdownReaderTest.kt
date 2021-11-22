package com.sample.function

import kotlin.test.Test

class MarkdownReaderTest {

    private val markdownReader = MarkdownReader()

    @Test
    fun testRead() {
        println(markdownReader.read(testText2))
    }


    val testText2 =
        "# 2021-11-21\n" +
                "# H1\n" +
                "本日は晴天なり\n" +
                "## H2\n" +
                "- text1\n" +
                "- text2\n" +
                "- text3\n" +
                "### Code Block\n" +
                "```java\n" +
                "public static void main(String[]args){\n" +
                "    System.out.println(\"Hello World\")\n" +
                "}\n" +
                " ```\n"


    val testText =
        """
        # 2021-11-21　
        # H1
        本日は晴天なり
        ## H2
        - text1
        - text2
        - text3
        ### Code Block
        ```java
        public static void main(String[]args){
            System.out.println("Hello World")
        }
        ```
        """
}