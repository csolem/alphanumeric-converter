package com.github.csolem.alphanumeric

import kotlin.math.pow

class AlphaNumericConverter {

    companion object {
        private val ALPHABET: CharArray = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray()
        private val ALPHABET_LENGTH = ALPHABET.size

        public fun generate(id: Int, numberOfGeneratedCharacters: Int): String {
            val maxValue: Long = (ALPHABET_LENGTH.toFloat().pow(numberOfGeneratedCharacters) - 1).toLong()
            val number = id % maxValue

            return convert(number).padStart(numberOfGeneratedCharacters, '0')
        }

        private fun convert(number: Long): String {
            if (number < 0) {
                throw IllegalArgumentException("Can not convert negative numbers: $number")
            }
            if (number == 0L) {
                return "0"
            }

            val stringBuilder: java.lang.StringBuilder = java.lang.StringBuilder()
            var remaining = number
            while (remaining != 0L) {
                stringBuilder.append(ALPHABET[(remaining % ALPHABET_LENGTH).toInt()])
                remaining /= ALPHABET_LENGTH.toLong()
            }

            return stringBuilder.reverse().toString()
        }
    }
}

