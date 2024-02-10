package com.sliderzxc.telegram.bot.github.trending.repositories.core.data.entities

import kotlinx.serialization.Serializable

@Serializable
data class GithubRepositoryEntity(
    val description: String? = null,
    val language: String? = null,
    val forks: Int? = null,
    val stargazers_count: Int? = null,
    val html_url: String? = null,
    val name: String? = null,
    val owner: GithubRepositoryOwner? = null
) {
    fun formatToString(): String {

        //return "\uD83D\uDCCB Name: $name ($html_url)\n" +
        return "\uD83D\uDCCB Name: <a href=\"$html_url\">$name</a>\n" +
        "\uD83D\uDCDD Description: $description\n" +
        "\uD83D\uDC64 Author: ${owner?.login}\n" +
        "\uD83C\uDF10 Language: $language\n" +
        "⭐\uFE0F Stars: $stargazers_count\n" +
        "\uD83C\uDF74 Forks: $forks"
    }
}

@Serializable
data class GithubRepositoryOwner(
    val login: String? = null
)