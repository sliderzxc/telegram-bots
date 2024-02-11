package com.sliderzxc.telegram.bot.github.trending.repositories.core.data.repositories

import com.sliderzxc.telegram.bot.github.trending.repositories.core.data.entities.GithubRepositoryEntity
import com.sliderzxc.telegram.bot.github.trending.repositories.core.data.entities.ProgrammingLanguage
import com.sliderzxc.telegram.bot.github.trending.repositories.core.domain.repositories.GithubRepository
import kotlinx.serialization.json.Json
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import org.jsoup.Jsoup

class GithubRepositoryImpl(
    private val json: Json
) : GithubRepository {
    override suspend fun getTrendingRepositoriesUrls(
        programmingLanguage: ProgrammingLanguage
    ): List<String> {
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

    override suspend fun getInfoByRepository(url: String): GithubRepositoryEntity {
        val formattedUrl = "https://api.github.com/repos/${url.removePrefix("https://github.com/").removeSuffix("/")}"
        println(formattedUrl)

        val client = OkHttpClient()

        val request = Request.Builder()
            .url(formattedUrl)
            .header("Authorization", "")
            .build()

        return try {
            val response: Response = client.newCall(request).execute()

            if (response.isSuccessful) {
                val responseBody = response.body?.string()
                val entity = json.decodeFromString<GithubRepositoryEntity>(responseBody!!)
                entity
            } else {
                // Handle non-success response codes here
                throw IllegalStateException("GitHub API request failed with status code ${response.code}")
            }
        } catch (e: Exception) {
            println("Error: ${e.message}")
            throw e
        }
    }
}