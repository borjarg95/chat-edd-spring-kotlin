package com.borjarg95.chateddspringkotlin.message.infra

import org.springframework.beans.factory.annotation.Autowired

/**
 * Locate beans inside objects which lifecycle is outside the control of application context.
 *
 * The preferred way to use bean dependencies is by injecting it, but this is only possible if the object lifecycle
 * is managed by the application context. In some cases this is not possible, for example when instances are created
 * calling directly the constructor (the class is not `@Singleton` neither `@Prototype` nor something like these).
 *
 * In theses cases if inside this instances you need to use a bean you can use this class to locate manually the bean.
 */
object ServiceLocator {

    @Autowired
    internal lateinit var holder: ServiceLocatorHolder

    internal fun isInitialized(): Boolean = holder !== UndefinedServiceLocator


    fun <T> locate(clazz: Class<T>): T = holder.locate(clazz)
    fun <T> locate(clazz: Class<T>, stereotype: Class<out Annotation>): T =
        holder.locate(clazz, stereotype)

    fun <T> locateCollection(clazz: Class<T>): Collection<T> = holder.locateCollection(clazz)
    fun <T> locate(clazz: Class<T>, name: String): T = holder.locate(clazz, name)

    inline fun <reified T> locate(name: String): T = locate(T::class.java, name)
    inline fun <reified T> locate(): T = locate(T::class.java)
    inline fun <reified T> locateBy(stereotype: Class<out Annotation>): T =
        locate(T::class.java, stereotype)

    inline fun <reified T> locateCollection(): Collection<T> = locateCollection(T::class.java)
}

internal object UndefinedServiceLocator : ServiceLocatorHolder {
    override fun <T> locate(clazz: Class<T>, stereotype: Class<out Annotation>): T =
        locate(clazz)

    override fun <T> locate(clazz: Class<T>, name: String): T = throw UnsupportedOperationException(
        "Undefined ServiceLocator, some ServiceLocator should be configured for the class ${clazz.name}"
    )


    override fun <T> locateCollection(clazz: Class<T>) = throw UnsupportedOperationException(
        "Undefined ServiceLocator, some ServiceLocator should be configured for the class ${clazz.name}"
    )

    override fun <T> locate(clazz: Class<T>): T = throw UnsupportedOperationException(
        "Undefined ServiceLocator, some ServiceLocator should be configured for the class ${clazz.name}"
    )
}
