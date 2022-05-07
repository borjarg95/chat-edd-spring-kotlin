package com.borjarg95.chateddspringkotlin.message.usecase.qry;

import com.borjarg95.chateddspringkotlin.message.infra.ServiceLocator.locate
import com.borjarg95.chateddspringkotlin.message.model.Message
import com.borjarg95.chateddspringkotlin.message.model.MessageDto
import com.borjarg95.chateddspringkotlin.message.repository.MessageRepository
import com.borjarg95.chateddspringkotlin.message.usecase.Query
import org.bson.types.ObjectId
import org.springframework.context.ApplicationContext
import reactor.core.publisher.Mono

class GetMessageQry(
    private val messageId: ObjectId,
    private val repo: MessageRepository = locate()
): Query<Mono<Message>> {
    override fun run(): Mono<Message> {
        return repo.findById(messageId)
    }
}
