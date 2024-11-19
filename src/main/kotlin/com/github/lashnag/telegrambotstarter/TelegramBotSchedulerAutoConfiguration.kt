package com.github.lashnag.telegrambotstarter

import com.pengrad.telegrambot.TelegramBot
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.annotation.EnableScheduling

@EnableScheduling
@Configuration
class TelegramBotSchedulerAutoConfiguration {
    @Bean
    fun createScheduler(telegramBot: TelegramBot, updatesServices: List<UpdatesService>): UpdatesScheduler {
        return UpdatesScheduler(telegramBot, updatesServices)
    }
}