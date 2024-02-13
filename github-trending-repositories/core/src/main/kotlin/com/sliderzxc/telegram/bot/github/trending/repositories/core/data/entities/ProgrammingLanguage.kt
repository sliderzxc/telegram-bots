package com.sliderzxc.telegram.bot.github.trending.repositories.core.data.entities

enum class ProgrammingLanguage(val language: String, val threadId: Long) {
    Core("", 1),
    Kotlin("Kotlin", 341),
    Java("Java", 343),
}

val AllProgrammingLanguages = listOf(
    ProgrammingLanguage.Core,
    ProgrammingLanguage.Kotlin,
    ProgrammingLanguage.Java,
)