package com.sliderzxc.telegram.bot.github.trending.repositories.domain.usecase

import com.sliderzxc.telegram.bot.github.trending.repositories.domain.repositories.FormattingRepository

class GetRepositoriesUseCase(
    private val formattingRepository: FormattingRepository,
) {
    operator fun invoke(): List<String> {
        return emptyList()
    }
}