package com.sliderzxc.telegram.bot.github.trending.repositories.core.limiter

import dev.inmo.tgbotapi.bot.exceptions.TooMuchRequestsException
import dev.inmo.tgbotapi.bot.settings.limiters.RequestLimiter
import kotlinx.coroutines.delay

object GithubTrendingRepositoriesRequestsLimiter : RequestLimiter {
    override suspend fun <T> limit(block: suspend () -> T): T {
        return try {
            block()
        } catch (exception: TooMuchRequestsException) {
            delay(exception.retryAfter.leftToRetry)
            limit(block)
        }
    }
}
