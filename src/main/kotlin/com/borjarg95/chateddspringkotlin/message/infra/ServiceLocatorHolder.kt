package com.borjarg95.chateddspringkotlin.message.infra

internal interface ServiceLocatorHolder {

    fun <T> locate(clazz: Class<T>): T
    fun <T> locate(clazz: Class<T>, stereotype: Class<out Annotation>): T
    fun <T> locateCollection(clazz: Class<T>): Collection<T>
    fun <T> locate(clazz: Class<T>, name: String): T
}
