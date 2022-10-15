package com.example.wbsfinancialbackend.infrastructure.exceptions

import java.io.Serial

class NotSupportedException(message: String?) : RuntimeException(message) {
    companion object {
        @Serial
        private val serialVersionUID = 3472132013034830599L
    }
}
