package com.sliderzxc.telegram.bot.github.trending.repositories.domain.repositories

import com.sliderzxc.telegram.bot.github.trending.repositories.common.parser.ProgrammingLanguage

interface GithubTrendingRepository {
    fun getTrendingRepositories(
        programmingLanguage: ProgrammingLanguage = ProgrammingLanguage.Core
    ): List<String>
}