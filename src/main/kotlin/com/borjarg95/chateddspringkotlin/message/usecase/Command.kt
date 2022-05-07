package com.borjarg95.chateddspringkotlin.message.usecase

@FunctionalInterface
interface Command<T> {

    suspend fun run(): T
}
