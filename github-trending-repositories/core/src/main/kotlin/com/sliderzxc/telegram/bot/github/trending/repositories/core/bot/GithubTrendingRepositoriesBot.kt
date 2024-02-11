package com.sliderzxc.telegram.bot.github.trending.repositories.core.bot

import com.sliderzxc.telegram.bot.github.trending.repositories.core.domain.usecase.GetRepositoriesUseCase
import com.sliderzxc.telegram.bot.github.trending.repositories.core.limiter.GithubTrendingRepositoriesRequestsLimiter
import com.sliderzxc.telegram.bot.github.trending.utils.coroutines.periodicTask
import com.sliderzxc.telegram.bot.github.trending.utils.time.today
import dev.inmo.tgbotapi.bot.ktor.telegramBot
import dev.inmo.tgbotapi.extensions.api.send.send
import dev.inmo.tgbotapi.extensions.api.send.sendTextMessage
import dev.inmo.tgbotapi.extensions.behaviour_builder.buildBehaviourWithLongPolling
import dev.inmo.tgbotapi.extensions.behaviour_builder.triggers_handling.onCommand
import dev.inmo.tgbotapi.types.IdChatIdentifier
import dev.inmo.tgbotapi.types.InlineQueries.InputMessageContent.InputTextMessageContent
import dev.inmo.tgbotapi.types.LinkPreviewOptions
import dev.inmo.tgbotapi.types.message.HTML
import kotlinx.coroutines.delay

class GithubTrendingRepositoriesBot(
    botToken: String,
    private val getRepositoriesUseCase: GetRepositoriesUseCase
) {
    private val bot = telegramBot(botToken) {
        requestsLimiter = GithubTrendingRepositoriesRequestsLimiter
    }

    suspend fun start() = bot.buildBehaviourWithLongPolling {
        val some = InputTextMessageContent(
            formatAsHtml("somethingdsda"),
            HTML,
            LinkPreviewOptions.Disabled
        )
        bot.sendTextMessage(
            chatId = IdChatIdentifier(-1002051124214),
            threadId = 253,
            text = some.text,
            linkPreviewOptions = LinkPreviewOptions.Disabled
        )
//        periodicTask(1000000) {
//            val repositoriesData = getRepositoriesUseCase.invoke().map {
//                it.formatToString()
//            }
//
//            // Split the data into two parts
//            val todayDate = listOf("🟩 Today: ${today()}")
//            val dataPart1 = repositoriesData.take(repositoriesData.size / 2)
//            val dataPart2 = repositoriesData.drop(repositoriesData.size / 2)
//
//            // Send the first part
//            bot.sendTextMessage(
//                chatId = IdChatIdentifier(-1002051124214),
//                threadId = 253,
//                text = todayDate.joinToString() + "\n" + dataPart1.joinToString("\n"),
//                linkPreviewOptions = LinkPreviewOptions.Disabled
//            )
//
//            // Wait for a short time (optional)
//            delay(1000)
//
//            // Send the second part
//            bot.sendTextMessage(
//                chatId = IdChatIdentifier(-1002051124214),
//                threadId = 253,
//                text = dataPart2.joinToString("\n"),
//                linkPreviewOptions = LinkPreviewOptions.Disabled
//            )
//        }
    }.join()
}

fun formatAsHtml(text: String): String {
    // Wrap the text in <a> tags to create a link
    val linkedText = "<a href=\"http://example.com\">$text</a>"

    // Apply blue color using <font> tag
    return "<font color=\"#0000FF\">$linkedText</font>"
}