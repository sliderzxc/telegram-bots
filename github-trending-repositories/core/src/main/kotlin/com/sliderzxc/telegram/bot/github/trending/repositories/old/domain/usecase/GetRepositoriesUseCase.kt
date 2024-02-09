package com.sliderzxc.telegram.bot.github.trending.repositories.old.domain.usecase

import com.sliderzxc.telegram.bot.github.trending.repositories.old.data.entities.ProgrammingLanguage
import com.sliderzxc.telegram.bot.github.trending.repositories.old.domain.repositories.GithubTrendingRepository

class GetRepositoriesUseCase(
    private val githubTrendingRepository: GithubTrendingRepository
) {
    operator fun invoke(
        programmingLanguage: ProgrammingLanguage = ProgrammingLanguage.Core
    ): List<String> {
        return githubTrendingRepository.getTrendingRepositories(programmingLanguage)
    }
}