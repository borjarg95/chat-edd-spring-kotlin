package com.borjarg95.chateddspringkotlin.message.queue

import com.borjarg95.chateddspringkotlin.message.model.MessageDto
import com.borjarg95.chateddspringkotlin.message.usecase.cmd.CreateMessageCmd
import com.borjarg95.chateddspringkotlin.message.usecase.qry.GetMessageQry
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service
import sun.plugin2.message.Message

@Service
class MessageListener(
) {

    @KafkaListener(id = "createMessageQueue", topicPattern = "input")
    suspend fun saveMessage(inputMessage: MessageDto) {
        CreateMessageCmd(inputMessage).run()
    }
}