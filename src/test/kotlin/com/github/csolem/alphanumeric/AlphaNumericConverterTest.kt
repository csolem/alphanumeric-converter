package com.github.csolem.alphanumeric

import com.github.csolem.alphanumeric.AlphaNumericConverter.Companion.generate
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AlphaNumericConverterTest {

    @Test
    fun `10 0A`() {
        val generated = generate(10, 2)
        println(generated)
        assertThat(generated).isEqualTo("0A")
    }

    @Test
    fun many() {
        val generated = (1..<(36 * 36))
            .map {
                val generated = generate(it, 2)
                println(generated)
                generated
            }
            .toList()

        assertThat(generated)
            .doesNotHaveDuplicates()
    }

    private fun combinations() = Stream.of(
        Pair(1, "01"),
        Pair(10, "0A"),
        Pair(20, "0K"),
        Pair(30, "0U"),
        Pair(59, "1N"),
        Pair(1296, "01")
    )

    @ParameterizedTest
    @MethodSource("combinations")
    fun test(parameter: Pair<Int, String>) {
        val generated = generate(parameter.first, 2)
        println(generated)
        assertThat(generated).isEqualTo(parameter.second)
    }
}
