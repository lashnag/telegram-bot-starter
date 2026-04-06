package com.github.lashnag.telegrambotstarter

import com.pengrad.telegrambot.TelegramBot
import okhttp3.OkHttpClient
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.concurrent.TimeUnit

@Configuration
class TelegramBotAutoConfiguration {

    @Value("\${telegram-bot-starter.bot.token}")
    private lateinit var botToken: String

    @Value("\${telegram-bot-starter.client.connection-timeout}")
    private lateinit var connectionTimeout: String

    @Value("\${telegram-bot-starter.client.read-timeout}")
    private lateinit var readTimeout: String

    @Bean
    fun telegramBot(): TelegramBot {
        val okHttpClient = OkHttpClient.Builder()
            .callTimeout(connectionTimeout.toLong(), TimeUnit.MILLISECONDS)
            .connectTimeout(connectionTimeout.toLong(), TimeUnit.MILLISECONDS)
            .readTimeout(readTimeout.toLong(), TimeUnit.MILLISECONDS)
            .writeTimeout(readTimeout.toLong(), TimeUnit.MILLISECONDS)
            .build()

        return TelegramBot.Builder(botToken)
            .okHttpClient(okHttpClient)
            .build()
    }
}