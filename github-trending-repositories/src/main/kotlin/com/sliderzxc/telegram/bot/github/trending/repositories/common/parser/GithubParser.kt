package com.sliderzxc.telegram.bot.github.trending.repositories.common.parser

import org.jsoup.Jsoup
import java.io.IOException


object GithubParser {
    fun parseTrendingRepositories(programmingLanguage: ProgrammingLanguage): List<String> {
        val url = "https://github.com/trending/${programmingLanguage.language}"

        return try {
            val document = Jsoup.connect(url).get()

            val codeWord = "stargazers"
            document.select("a[href]").map {
                it.attr("href")
            }.filter { it.contains(codeWord) }.map { repositoryId ->
                "https://github.com${repositoryId.replace(codeWord, "")}"
            }

        } catch (e: IOException) {
            println("message: ${e.message}")
            emptyList()
        }
    }
}