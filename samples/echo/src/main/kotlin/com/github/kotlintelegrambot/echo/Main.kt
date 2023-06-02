package com.github.kotlintelegrambot.echo

import com.github.kotlintelegrambot.bot
import com.github.kotlintelegrambot.dispatch
import com.github.kotlintelegrambot.dispatcher.command
import com.github.kotlintelegrambot.dispatcher.sticker
import com.github.kotlintelegrambot.entities.ChatId
import com.github.kotlintelegrambot.entities.InlineKeyboardMarkup
import com.github.kotlintelegrambot.entities.keyboard.InlineKeyboardButton
import kotlinx.coroutines.delay

fun main() {
    val bot = bot {
        token = ""

        dispatch {
            sticker {
                bot.sendSticker(chatId = ChatId.fromId(message.chat.id), sticker = media.fileId, replyMarkup = null)
            }
//            text {
//                bot.sendMessage(chatId = ChatId.fromId(message.chat.id), text = text)
//            }
            command("greeting") {
                bot.sendMessage(chatId = ChatId.fromId(message.chat.id), text = "Здоров, пёс ??!")
                delay(1000)
                bot.sendMessage(chatId = ChatId.fromId(message.chat.id), text = "Как сам ??!")
            }
            command("markup") {

                    val buttons = listOf(
                        listOf("Кнопка 1", "Кнопка 2"),
                        listOf("Кнопка 3", "Кнопка 4")
                    ).map { it.map { InlineKeyboardButton.Url(it, "https://www.google.com/search?q=%D0%B3%D0%B0%D1%87%D0%B8%D0%BC%D1%83%D1%87%D0%B8+%D0%BC%D0%B5%D0%BC&sxsrf=APwXEdfbi6LXq2QnnnLl9-7DAxMrzyJPOA:1685724303430&source=lnms&tbm=isch&sa=X&ved=2ahUKEwit962yhKX_AhVj_CoKHWeUD1YQ_AUoAXoECAEQAw&biw=1384&bih=633&dpr=1.39#imgrc=2FEI4GDXw-9yiM") } }
                val markup = InlineKeyboardMarkup.create(buttons)

                bot.sendMessage(chatId = ChatId.fromId(message.chat.id), text = "markup", replyMarkup = markup)
            }
        }
    }

    bot.startPolling()
}
