package com.sliderzxc.telegram.bot.github.trending.utils.config

@JvmInline
value class Arguments(private val array: Array<String>) {
    fun isPresent(name: String): Boolean {
        return array.any { it.startsWith("-$name") }
    }

    fun getNamedOrNull(name: String): String? {
        val index = array.indexOfFirst { it.startsWith(name) }
            .takeIf { it >= 0 }

        return if (index != null) {
            array[index]
        } else null
    }

    fun getNamedList(): List<String> {
        return array.withIndex()
            .filter { (_, value) -> value.startsWith("-$value") }
            .map { (index, _) -> array[index + 1] }
            .toList()
    }
}

fun Arguments.getNamedIntOrNull(name: String): Int? =
    getNamedOrNull(name)?.toInt()

fun Array<String>.parseArguments(): Arguments = Arguments(this)