package com.example.wbsfinancialbackend.utils.validation.customannotations.enums

import com.example.wbsfinancialbackend.enums.BaseEnum
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

class ValueOfEnumValidator: ConstraintValidator<ValueOfEnum, CharSequence> {
    private var acceptedValues: List<String> = listOf()

    override fun initialize(annotation: ValueOfEnum) {
        super.initialize(annotation)

        acceptedValues = annotation.enumClass.java.enumConstants
            .map { e -> if (annotation.byName) e.name else (e as BaseEnum).value }.toList()
    }

    override fun isValid(value: CharSequence?, context: ConstraintValidatorContext): Boolean {
        return if (value == null) {
            true
        } else acceptedValues.contains(value.toString())

    }
}