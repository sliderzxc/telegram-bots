package com.sliderzxc.telegram.bot.github.trending.utils.coroutines

import kotlinx.coroutines.delay

suspend fun periodicTask(intervalMillis: Long, task: suspend () -> Unit) {
    while (true) {
        task()
        delay(intervalMillis)
    }
}