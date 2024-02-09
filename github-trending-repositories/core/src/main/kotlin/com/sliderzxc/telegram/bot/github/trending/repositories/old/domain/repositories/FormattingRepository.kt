package com.sliderzxc.telegram.bot.github.trending.repositories.old.domain.repositories

import com.sliderzxc.telegram.bot.github.trending.repositories.old.data.entities.ProgrammingLanguage
import com.sliderzxc.telegram.bot.github.trending.repositories.old.data.entities.TrendingRepositoryEntity

interface FormattingRepository {
    fun format(data: List<String>, programmingLanguage: ProgrammingLanguage): List<TrendingRepositoryEntity>
}