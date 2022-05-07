package com.borjarg95.chateddspringkotlin.message.model

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonInclude
import lombok.EqualsAndHashCode
import org.bson.codecs.pojo.annotations.BsonId
import org.bson.internal.Base64
import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.io.Serializable
import java.time.LocalDateTime

@Document
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_EMPTY)
data class Message(

    @Id
    val id: ObjectId = ObjectId.get(),
    val from: String,
    val to: String,
    val text: String? = null,
    val imgPath: String? = null,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val readAt: LocalDateTime? = null
): Serializable
