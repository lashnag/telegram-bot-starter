package com.github.lashnag.telegrambotstarter

import com.pengrad.telegrambot.TelegramBot
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.annotation.EnableScheduling

@EnableScheduling
@Configuration
class TelegramBotAutoConfiguration {
    @Value("\${telegram.bot.token}")
    private val botToken: String? = null

    @Bean
    fun telegramBot(): TelegramBot {
        return TelegramBot(botToken)
    }
}