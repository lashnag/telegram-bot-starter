package com.github.lashnag.telegrambotstarter

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties("telegram.bot")
data class TelegramBotProperties(
    val token: String,
)