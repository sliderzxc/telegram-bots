package com.sliderzxc.telegram.bot.github.trending.repositories.core.bot

import com.sliderzxc.telegram.bot.github.trending.repositories.core.data.entities.AllProgrammingLanguages
import com.sliderzxc.telegram.bot.github.trending.repositories.core.data.entities.ConfigTokens
import com.sliderzxc.telegram.bot.github.trending.repositories.core.domain.usecase.GetRepositoriesUseCase
import com.sliderzxc.telegram.bot.github.trending.repositories.core.limiter.GithubTrendingRepositoriesRequestsLimiter
import com.sliderzxc.telegram.bot.github.trending.utils.coroutines.periodicTask
import com.sliderzxc.telegram.bot.github.trending.utils.time.today
import dev.inmo.tgbotapi.bot.ktor.telegramBot
import dev.inmo.tgbotapi.extensions.api.send.sendTextMessage
import dev.inmo.tgbotapi.extensions.behaviour_builder.buildBehaviourWithLongPolling
import dev.inmo.tgbotapi.types.IdChatIdentifier
import dev.inmo.tgbotapi.types.LinkPreviewOptions
import dev.inmo.tgbotapi.types.message.HTMLParseMode
import kotlinx.coroutines.delay

class GithubTrendingRepositoriesBot(
    private val configTokens: ConfigTokens,
    private val getRepositoriesUseCase: GetRepositoriesUseCase
) {
    private val bot = telegramBot(configTokens.telegramToken) {
        requestsLimiter = GithubTrendingRepositoriesRequestsLimiter
    }

    suspend fun start() = bot.buildBehaviourWithLongPolling {
        periodicTask(10000000) {
            AllProgrammingLanguages.forEach { language ->
                val repositoriesData = getRepositoriesUseCase.invoke(
                    programmingLanguage = language,
                    githubToken = configTokens.githubToken
                ).map { it.formatToString() }

                val todayDate = listOf("🟩 Today: ${today()}\n")
                val dataPart1 = repositoriesData.take(repositoriesData.size / 2)
                val dataPart2 = repositoriesData.drop(repositoriesData.size / 2)

                bot.sendTextMessage(
                    chatId = IdChatIdentifier(-1002051124214),
                    threadId = if(language.threadId.toInt() == 1) null else language.threadId,
                    text = todayDate.joinToString() + "\n" + dataPart1.joinToString("\n"),
                    linkPreviewOptions = LinkPreviewOptions.Disabled,
                    parseMode = HTMLParseMode
                )
                delay(1000)
                bot.sendTextMessage(
                    chatId = IdChatIdentifier(-1002051124214),
                    threadId = if(language.threadId.toInt() == 1) null else language.threadId,
                    text = dataPart2.joinToString("\n"),
                    linkPreviewOptions = LinkPreviewOptions.Disabled,
                    parseMode = HTMLParseMode
                )
            }
        }
    }.join()
}