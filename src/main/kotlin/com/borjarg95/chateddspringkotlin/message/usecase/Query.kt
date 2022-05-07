package com.borjarg95.chateddspringkotlin.message.usecase

@FunctionalInterface
interface Query<T> {

    fun run(): T
}
