package com.sliderzxc.telegram.bot.github.trending.repositories.old.domain.repositories

import com.sliderzxc.telegram.bot.github.trending.repositories.old.data.entities.ProgrammingLanguage

interface GithubTrendingRepository {
    fun getTrendingRepositories(
        programmingLanguage: ProgrammingLanguage = ProgrammingLanguage.Core
    ): List<String>
}