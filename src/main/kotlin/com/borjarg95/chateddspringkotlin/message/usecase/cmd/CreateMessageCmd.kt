package com.borjarg95.chateddspringkotlin.message.usecase.cmd

import com.borjarg95.chateddspringkotlin.message.infra.ServiceLocator
import com.borjarg95.chateddspringkotlin.message.infra.ServiceLocator.locate
import com.borjarg95.chateddspringkotlin.message.model.Message
import com.borjarg95.chateddspringkotlin.message.model.MessageDto
import com.borjarg95.chateddspringkotlin.message.repository.MessageRepository
import com.borjarg95.chateddspringkotlin.message.usecase.Command
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import reactor.core.publisher.Mono
import kotlin.coroutines.coroutineContext

class CreateMessageCmd(
    private val messageDto: MessageDto,
    private val messageRepository: MessageRepository = locate(),
): Command<Mono<Message>> {
    override suspend fun run(): Mono<Message> {
        val message = Message(
            from = messageDto.from,
            to = messageDto.to,
            createdAt = messageDto.createdAt,
            readAt = messageDto.readAt,
            imgPath = messageDto.imgPath,
            text = messageDto.text
        )
        return messageRepository.save(message)
    }
}