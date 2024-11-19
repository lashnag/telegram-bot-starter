package com.github.lashnag.telegrambotstarter

import com.pengrad.telegrambot.TelegramBot
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class TelegramBotAutoConfiguration {

    @Value("\${telegram.bot.token}")
    private lateinit var botToken: String

    @Bean
    fun telegramBot(): TelegramBot {
        return TelegramBot(botToken)
    }
}