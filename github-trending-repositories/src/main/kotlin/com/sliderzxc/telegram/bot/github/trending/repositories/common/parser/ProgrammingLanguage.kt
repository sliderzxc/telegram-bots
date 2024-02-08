package com.sliderzxc.telegram.bot.github.trending.repositories.common.parser

enum class ProgrammingLanguage(val language: String) {
    Core(""),
    Kotlin("Kotlin"),
    Java("Java"),
}

val AllProgrammingLanguages = listOf(
    ProgrammingLanguage.Kotlin,
    ProgrammingLanguage.Java,
)