package com.sliderzxc.telegram.bot.github.trending.repositories.core.executor

import com.sliderzxc.telegram.bot.github.trending.repositories.core.data.entities.ProgrammingLanguage
import dev.inmo.tgbotapi.types.ChatIdWithThreadId

interface GithubTrendingRepositoriesExecutor {
    suspend fun sendRepositories(
        chatIdWithThreadId: ChatIdWithThreadId,
        language: ProgrammingLanguage = ProgrammingLanguage.Core,
    )
}