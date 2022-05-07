package com.borjarg95.chateddspringkotlin.message.model

import com.fasterxml.jackson.annotation.JsonInclude
import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import java.time.LocalDateTime

@JsonInclude(JsonInclude.Include.NON_EMPTY)
data class MessageDto(
    val from: String,
    val to: String,
    val text: String? = null,
    val imgPath: String? = null,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val readAt: LocalDateTime? = null
)