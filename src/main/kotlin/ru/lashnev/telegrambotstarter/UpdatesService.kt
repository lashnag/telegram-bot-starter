package ru.lashnev.telegrambotstarter

import com.pengrad.telegrambot.model.Update

interface UpdatesService {
    fun processUpdates(update: Update)
}