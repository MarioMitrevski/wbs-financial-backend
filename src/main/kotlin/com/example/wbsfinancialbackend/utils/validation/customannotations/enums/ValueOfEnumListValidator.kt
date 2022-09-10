package com.example.wbsfinancialbackend.utils.validation.customannotations.enums

import com.example.wbsfinancialbackend.enums.BaseEnum
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

class ValueOfEnumListValidator : ConstraintValidator<ValueOfEnum, List<CharSequence>> {
    private var acceptedValues: List<String> = listOf()

    override fun initialize(annotation: ValueOfEnum) {
        super.initialize(annotation)

        acceptedValues = annotation.enumClass.java.enumConstants
            .map { e -> if (annotation.byName) e.name else (e as BaseEnum).value }.toList()
    }

    override fun isValid(values: List<CharSequence>?, context: ConstraintValidatorContext): Boolean {
        return if (values == null) {
            true
        } else acceptedValues.containsAll(values.map { it.toString() })
    }
}