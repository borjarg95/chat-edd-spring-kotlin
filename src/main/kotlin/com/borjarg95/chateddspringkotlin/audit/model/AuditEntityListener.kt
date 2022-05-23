package com.borjarg95.chateddspringkotlin.audit.model

import org.springframework.boot.actuate.endpoint.SecurityContext
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component
import java.time.LocalDateTime
import javax.persistence.PrePersist
import javax.persistence.PreUpdate

@Suppress("JpaEntityListenerInspection")
@Component
class AuditEntityListener {

    @PrePersist
    fun prePersist(auditEntity: Auditable) {
        auditEntity.createdBy = kotlin.runCatching {
            SecurityContextHolder.getContext().authentication.principal.toString()
        }.getOrDefault("anonymous")
        auditEntity.createdAt = LocalDateTime.now()
    }

    @PreUpdate
    fun preUpdate(auditable: Auditable) {
        auditable.updatedBy = kotlin.runCatching {
            SecurityContextHolder.getContext().authentication.principal.toString()
        }.getOrDefault("anonymous")
        auditable.updatedAt = LocalDateTime.now()
    }
}
