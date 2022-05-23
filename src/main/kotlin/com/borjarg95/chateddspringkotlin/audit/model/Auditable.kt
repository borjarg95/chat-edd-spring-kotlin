package com.borjarg95.chateddspringkotlin.audit.model

import org.springframework.data.annotation.CreatedBy
import org.springframework.data.annotation.CreatedDate
import java.time.LocalDateTime
import javax.persistence.*

@MappedSuperclass
@EntityListeners(AuditEntityListener::class)
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
abstract class Auditable {

        @CreatedDate
        @Column(nullable = true, name = "created_at")
        var createdAt: LocalDateTime? = null

        @Column(nullable = true, name = "updated_at")
        var updatedAt: LocalDateTime? = null

        @CreatedBy
        @Column(nullable = true, name = "created_by")
        var createdBy: String? = null

        @Column(nullable = true, name = "updated_by")
        var updatedBy: String? = null
}
