package com.github.lashnag.telegrambotstarter

import com.pengrad.telegrambot.TelegramBot
import com.pengrad.telegrambot.model.Update
import com.pengrad.telegrambot.request.GetUpdates
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service

@Service
class UpdatesScheduler(
    private val bot: TelegramBot,
    private val updateServices: List<UpdatesService>
) {

    private var lastUpdateId = 0

    @Scheduled(fixedRateString = "\${telegram.scheduler.updatesFixedRate:1000}")
    fun getUpdates() {
        try {
            val getUpdatesRequest = GetUpdates().limit(1)
            if (lastUpdateId != 0) {
                getUpdatesRequest.offset(lastUpdateId + 1)
            }
            val getUpdatesResponse = bot.execute(getUpdatesRequest)
            val updates: List<Update> = getUpdatesResponse?.updates() ?: emptyList()

            if (updates.isNotEmpty()) {
                lastUpdateId = updates.last().updateId()
            }

            updates.forEach { update ->
                try {
                    logger.info("Start process update $update")
                    updateServices.forEach { it.processUpdates(update) }
                } catch (e: Exception) {
                    logger.error("Cant process update", e)
                }
            }
        } catch (e: Exception) {
            logger.error("Catch exception ${e.message}", e)
        }
    }

    companion object {
        val logger: Logger = LoggerFactory.getLogger(UpdatesScheduler::class.java)
    }
}