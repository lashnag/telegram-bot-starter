package com.github.lashnag.telegrambotstarter

import com.pengrad.telegrambot.TelegramBot
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class TelegramBotAutoConfiguration {
    @Bean
    fun telegramBot(telegramBotProperties: TelegramBotProperties): TelegramBot {
        return TelegramBot(telegramBotProperties.token)
    }
}