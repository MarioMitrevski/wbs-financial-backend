package com.example.wbsfinancialbackend.core.utils.validation.customannotations.enums

import javax.validation.Constraint
import javax.validation.Payload
import kotlin.reflect.KClass

@Target(
    AnnotationTarget.FIELD,
    AnnotationTarget.VALUE_PARAMETER,
)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
@Constraint(validatedBy = [ValueOfEnumValidator::class, ValueOfEnumListValidator::class])
annotation class ValueOfEnum(
    val enumClass: KClass<out Enum<*>>,
    val message: String = "must be any of enum {enumClass}",
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<out Payload>> = [],
    val byName: Boolean = true
)


