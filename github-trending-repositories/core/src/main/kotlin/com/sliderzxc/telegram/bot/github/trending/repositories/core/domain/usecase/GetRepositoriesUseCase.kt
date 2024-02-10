package com.sliderzxc.telegram.bot.github.trending.repositories.core.domain.usecase

import com.sliderzxc.telegram.bot.github.trending.repositories.core.data.entities.GithubRepositoryEntity
import com.sliderzxc.telegram.bot.github.trending.repositories.core.data.entities.ProgrammingLanguage
import com.sliderzxc.telegram.bot.github.trending.repositories.core.domain.repositories.GithubRepository

class GetRepositoriesUseCase(
    private val githubRepository: GithubRepository
) {
    suspend operator fun invoke(
        programmingLanguage: ProgrammingLanguage = ProgrammingLanguage.Core
    ): List<GithubRepositoryEntity> {
        return githubRepository.getTrendingRepositoriesUrls(programmingLanguage).map { url ->
            githubRepository.getInfoByRepository(url)
        }
    }
}