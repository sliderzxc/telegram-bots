package com.sliderzxc.telegram.bot.github.trending.repositories.domain.repositories

import com.sliderzxc.telegram.bot.github.trending.repositories.common.parser.ProgrammingLanguage
import com.sliderzxc.telegram.bot.github.trending.repositories.data.entities.TrendingRepositoryEntity

interface FormattingRepository {
    fun format(data: List<String>, programmingLanguage: ProgrammingLanguage): List<TrendingRepositoryEntity>
}