package com.borjarg95.chateddspringkotlin.message.infra.queue

import com.borjarg95.chateddspringkotlin.message.model.MessageDto
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service
import sun.plugin2.message.Message

@Service
class MessageListener {

    @KafkaListener(id = "", topicPattern = "input")
    fun saveMessage(inputMessage: MessageDto) {

        TODO()
    }
}