package com.sliderzxc.telegram.bot.github.trending.repositories.core.app

import com.sliderzxc.telegram.bot.github.trending.repositories.core.bot.GithubTrendingRepositoriesBot
import com.sliderzxc.telegram.bot.github.trending.repositories.core.constants.ArgumentConstants
import com.sliderzxc.telegram.bot.github.trending.repositories.core.data.entities.ConfigTokens
import com.sliderzxc.telegram.bot.github.trending.repositories.core.data.repositories.GithubRepositoryImpl
import com.sliderzxc.telegram.bot.github.trending.repositories.core.domain.usecase.GetRepositoriesUseCase
import com.sliderzxc.telegram.bot.github.trending.utils.config.parseArguments
import com.sliderzxc.telegram.bot.github.trending.utils.extensions.any.unit
import kotlinx.coroutines.coroutineScope
import kotlinx.serialization.json.Json

suspend fun main(args: Array<String>) = coroutineScope {
    val arguments = args.parseArguments()

    val telegramToken = arguments.getNamedOrNull(ArgumentConstants.TELEGRAM_BOT_TOKEN)
        ?: System.getenv(ArgumentConstants.TELEGRAM_BOT_TOKEN)
        ?: error("Telegram bot token was not provided")

    val githubToken = arguments.getNamedOrNull(ArgumentConstants.GITHUB_TOKEN)
        ?: System.getenv(ArgumentConstants.GITHUB_TOKEN)
        ?: error("Github token was not provided")

    val configTokens = ConfigTokens(
        githubToken = githubToken,
        telegramToken = telegramToken
    )

    val json = Json {
        ignoreUnknownKeys = true
    }

    GithubTrendingRepositoriesBot(
        configTokens = configTokens,
        GetRepositoriesUseCase(GithubRepositoryImpl(json))
    ).start()
}.unit