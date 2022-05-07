package com.borjarg95.chateddspringkotlin.message.infra


import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.getBeansWithAnnotation
import org.springframework.context.ApplicationContext
import org.springframework.stereotype.Component

@Suppress("UNCHECKED_CAST", "NULLABLE_TYPE_PARAMETER_AGAINST_NOT_NULL_TYPE_PARAMETER")
@Component
internal class MicronautServiceLocator internal constructor(
    @Autowired
    private val applicationContext: ApplicationContext
) : ServiceLocatorHolder {

    override fun <T> locate(clazz: Class<T>): T = applicationContext.getBean(clazz)
    override fun <T> locate(clazz: Class<T>, stereotype: Class<out Annotation>): T {
        return applicationContext.getBeansWithAnnotation<Annotation>()[clazz.name] as T
    }

    override fun <T> locate(clazz: Class<T>, name: String): T {
        return applicationContext.getBean(clazz, name)
    }

    override fun <T> locateCollection(clazz: Class<T>): Collection<T> = applicationContext.getBeanNamesForType(clazz).map {
        applicationContext.getBean(it, clazz) }

}
