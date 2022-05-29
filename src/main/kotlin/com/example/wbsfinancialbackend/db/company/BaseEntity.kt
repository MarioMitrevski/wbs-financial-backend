package com.example.wbsfinancialbackend.db.company

import lombok.EqualsAndHashCode
import org.hibernate.annotations.GenericGenerator
import java.util.*
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.MappedSuperclass

@MappedSuperclass
abstract class BaseEntity(
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private val id: UUID? = null
)