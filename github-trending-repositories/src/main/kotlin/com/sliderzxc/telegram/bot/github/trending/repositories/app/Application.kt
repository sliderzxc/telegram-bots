package com.sliderzxc.telegram.bot.github.trending.repositories.app

import com.sliderzxc.telegram.bot.github.trending.repositories.common.coroutines.periodicTask
import com.sliderzxc.telegram.bot.github.trending.repositories.common.parser.GithubParser
import com.sliderzxc.telegram.bot.github.trending.repositories.common.parser.ProgrammingLanguage
import dev.inmo.tgbotapi.bot.ktor.telegramBot
import dev.inmo.tgbotapi.extensions.api.bot.getMe
import dev.inmo.tgbotapi.extensions.api.send.reply
import dev.inmo.tgbotapi.extensions.api.send.sendTextMessage
import dev.inmo.tgbotapi.extensions.behaviour_builder.buildBehaviour
import dev.inmo.tgbotapi.extensions.behaviour_builder.buildBehaviourWithLongPolling
import dev.inmo.tgbotapi.extensions.behaviour_builder.triggers_handling.onCommand
import dev.inmo.tgbotapi.types.IdChatIdentifier
import dev.inmo.tgbotapi.types.Identifier
import dev.inmo.tgbotapi.types.MessageThreadId
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import java.util.Timer
import java.util.concurrent.TimeUnit
import kotlin.concurrent.schedule

suspend fun main() {
    val token = "6723098304:AAFiVn3teLzl49Gpfd9Kd799U-mO9f2yqBg"
    val bot = telegramBot(token)

    bot.buildBehaviourWithLongPolling {
        periodicTask(TimeUnit.MINUTES.toSeconds(1)) {
            val data = GithubParser.parseTrendingRepositories(ProgrammingLanguage.Kotlin)
            bot.sendTextMessage(
                chatId = IdChatIdentifier(-1002051124214),
                threadId = 2,
                text = data.joinToString("/n")
            )
            println(bot.getMe())
        }

        onCommand("start") {
            reply(it, "Chat ID: ${it.chat.id}")
        }
    }.join()
}