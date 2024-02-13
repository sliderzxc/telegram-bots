package com.sliderzxc.telegram.bot.github.trending.repositories.core.domain.repositories

import com.sliderzxc.telegram.bot.github.trending.repositories.core.data.entities.GithubRepositoryEntity
import com.sliderzxc.telegram.bot.github.trending.repositories.core.data.entities.ProgrammingLanguage

interface GithubRepository {
    suspend fun getTrendingRepositoriesUrls(
        programmingLanguage: ProgrammingLanguage = ProgrammingLanguage.Core
    ): List<String>

    suspend fun getInfoByRepository(url: String, githubToken: String): GithubRepositoryEntity
}