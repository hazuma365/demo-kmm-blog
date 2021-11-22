package com.sample.content

import androidx.compose.runtime.Composable
import com.sample.components.ContainerInSection

@Composable
fun Articles() {
    ContainerInSection {  markdown(markdownText) }
    ContainerInSection {  markdown(markdownText) }
    ContainerInSection {  markdown(markdownText) }
}
data class ArticleData(
    val title: String,
    val createDate: String,
    val tags: List<String>,
    val content: String,
)