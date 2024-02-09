package com.sliderzxc.telegram.bot.github.trending.repositories.core.app

import com.sliderzxc.telegram.bot.github.trending.repositories.core.bot.GithubTrendingRepositoriesBot
import com.sliderzxc.telegram.bot.github.trending.utils.extensions.any.unit
import kotlinx.coroutines.coroutineScope

suspend fun main() = coroutineScope{
    val token = ""
//    val bot = telegramBot(token)
//
//    bot.buildBehaviourWithLongPolling {
//        periodicTask(TimeUnit.MINUTES.toMinutes(1)) {
//            val data = GithubTrendingRepositoryImpl().getTrendingRepositories(ProgrammingLanguage.Kotlin)
//            bot.sendTextMessage(
//                chatId = IdChatIdentifier(-1002051124214),
//                threadId = 2,
//                text = "Hello world"
//            )
//            println(data.joinToString("\n"))
//        }
//
//        onCommand("start") {
//            reply(it, "Chat ID: ${it.chat.id}")
//        }
//    }.join()
    GithubTrendingRepositoriesBot(
        botToken = token
    ).start()
}.unit