package com.borjarg95.chateddspringkotlin.message.repository

import com.borjarg95.chateddspringkotlin.message.model.Message
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository


@Repository
interface MessageRepository: ReactiveMongoRepository<Message, ObjectId>