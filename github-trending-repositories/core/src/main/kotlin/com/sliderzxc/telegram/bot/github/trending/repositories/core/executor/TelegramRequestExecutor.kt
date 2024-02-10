package com.sliderzxc.telegram.bot.github.trending.repositories.core.executor

import com.sliderzxc.telegram.bot.github.trending.repositories.core.data.entities.ProgrammingLanguage
import dev.inmo.tgbotapi.bot.TelegramBot
import dev.inmo.tgbotapi.types.ChatIdWithThreadId

class TelegramRequestExecutor(
    private val bot: TelegramBot
) : GithubTrendingRepositoriesExecutor {
    override suspend fun sendRepositories(
        chatIdWithThreadId: ChatIdWithThreadId,
        language: ProgrammingLanguage,
    ) {
    }
}