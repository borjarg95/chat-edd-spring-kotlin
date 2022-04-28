package com.borjarg95.chateddspringkotlin.message.usecase.qry

import com.borjarg95.chateddspringkotlin.message.model.Message
import com.borjarg95.chateddspringkotlin.message.infra.repository.MessageRepository

class CreateMessageCmd(
    private val messageRepository: MessageRepository,

    val inputMessage: Message
) {
}