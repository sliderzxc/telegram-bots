package com.sliderzxc.telegram.bot.github.trending.repositories.core.data.entities

import dev.inmo.tgbotapi.types.message.textsources.bold
import dev.inmo.tgbotapi.types.message.textsources.link
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
        return "\uD83D\uDCCB" + bold("Name: ").html + link(name.toString(), html_url.toString()).html + "\n" +
                "\uD83D\uDCDD" + bold("Description: ").html + "$description\n" +
                "\uD83D\uDC64" + bold("Author: ").html + "${owner?.login}\n" +
                "\uD83C\uDF10" + bold("Language: ").html + "$language\n" +
                "⭐\uFE0F" + bold("Stars: ").html + "$stargazers_count\n" +
                "\uD83C\uDF74" + bold("Forks: ").html + "$forks\n"
    }
}


@Serializable
data class GithubRepositoryOwner(
    val login: String? = null,
)