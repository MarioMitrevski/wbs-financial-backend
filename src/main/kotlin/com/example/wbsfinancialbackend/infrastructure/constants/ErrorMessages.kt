package com.example.wbsfinancialbackend.infrastructure.constants

class ErrorMessages {

    companion object {

        fun entityNotFoundMessage(entity: String): String {
            return "$entity not found!"
        }

        fun entityNotFoundMessage(entity: String, id: String): String {
            return "$entity $id not found!"
        }

        fun entityNotSupportedMessage(entity: String): String {
            return "$entity not supported!"
        }
    }

}