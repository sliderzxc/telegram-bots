package com.sliderzxc.telegram.bot.github.trending.repositories.core.app

import com.sliderzxc.telegram.bot.github.trending.repositories.core.bot.GithubTrendingRepositoriesBot
import com.sliderzxc.telegram.bot.github.trending.repositories.core.data.repositories.GithubRepositoryImpl
import com.sliderzxc.telegram.bot.github.trending.repositories.core.domain.usecase.GetRepositoriesUseCase
import com.sliderzxc.telegram.bot.github.trending.utils.extensions.any.unit
import kotlinx.coroutines.coroutineScope
import kotlinx.serialization.json.Json

suspend fun main() = coroutineScope {
    val token = ""

    val json = Json {
        ignoreUnknownKeys = true
    }

    GithubTrendingRepositoriesBot(
        botToken = token,
        GetRepositoriesUseCase(GithubRepositoryImpl(json))
    ).start()
}.unit