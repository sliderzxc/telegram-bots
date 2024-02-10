package com.sliderzxc.telegram.bot.github.trending.repositories.core.app

import com.sliderzxc.telegram.bot.github.trending.repositories.core.bot.GithubTrendingRepositoriesBot
import com.sliderzxc.telegram.bot.github.trending.repositories.core.data.repositories.GithubRepositoryImpl
import com.sliderzxc.telegram.bot.github.trending.repositories.core.domain.usecase.GetRepositoriesUseCase
import com.sliderzxc.telegram.bot.github.trending.utils.extensions.any.unit
import kotlinx.coroutines.coroutineScope
import kotlinx.serialization.json.Json

suspend fun main() = coroutineScope {


    val json = Json {
        ignoreUnknownKeys = true
    }

    //bot.buildBehaviourWithLongPolling {
//        periodicTask(TimeUnit.MINUTES.toMinutes(1)) {
//            val data = GithubTrendingRepositoryImpl().getTrendingRepositories(ProgrammingLanguage.Kotlin)
//            bot.sendTextMessage(
//                chatId = IdChatIdentifier(-1002051124214),
//                threadId = 2,
//                text = "Hello world"
//            )
//            println(data.joinToString("\n"))
//        }

//        bot.sendTextMessage(
//            chatId = IdChatIdentifier(-1002051124214),
//            threadId = 2,
//            text = "Hello world"
//        )
//
//        onCommand("come") {
//            reply(it, "Chat ID: ${it.chat.id}")
//        }
//    }.join()
    GithubTrendingRepositoriesBot(
        botToken = token,
        GetRepositoriesUseCase(GithubRepositoryImpl(json))
    ).start()
}.unit