package com.sliderzxc.telegram.bot.github.trending.repositories.core.bot

import com.sliderzxc.telegram.bot.github.trending.repositories.core.executor.GithubTrendingRepositoriesExecutor
import com.sliderzxc.telegram.bot.github.trending.repositories.core.executor.TelegramRequestExecutor
import com.sliderzxc.telegram.bot.github.trending.repositories.core.limiter.GithubTrendingRepositoriesRequestsLimiter
import dev.inmo.tgbotapi.bot.ktor.telegramBot
import dev.inmo.tgbotapi.extensions.utils.updates.retrieving.longPolling

class GithubTrendingRepositoriesBot(
    botToken: String,
) {
    private val bot = telegramBot(botToken) {
        requestsLimiter = GithubTrendingRepositoriesRequestsLimiter
    }

    fun start() = bot.longPolling {

    }
}