package com.github.lashnag.telegrambotstarter

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties("telegram.scheduler")
data class TelegramBotSchedulerProperties(
    val updatesFixedRate: String = "1000"
)
