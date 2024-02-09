package com.sliderzxc.telegram.bot.github.trending.repositories.old.data.repositories

import com.sliderzxc.telegram.bot.github.trending.repositories.old.data.entities.ProgrammingLanguage
import com.sliderzxc.telegram.bot.github.trending.repositories.old.domain.repositories.GithubTrendingRepository
import org.jsoup.Jsoup
import java.io.IOException

class GithubTrendingRepositoryImpl : GithubTrendingRepository {
    override fun getTrendingRepositories(programmingLanguage: ProgrammingLanguage): List<String> {
        val url = "https://github.com/trending/${programmingLanguage.language}"

        return try {
            val document = Jsoup.connect(url).get()

            val codeWord = "stargazers"
            document.select("a[href]").map {
                it.attr("href")
            }.filter { it.contains(codeWord) }.map { repositoryId ->
                "https://github.com${repositoryId.replace(codeWord, "")}"
            }

        } catch (e: Exception) {
            println("message: ${e.message}")
            emptyList()
        }
    }
}