package advent.day4

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Day4UnitTest {
  private val day = "day4"

  @Test
  fun `solve1 -- test 1 -- returns expected value`() {
    val result = day().solve1("$day/test1.txt")

    assertThat(result).isEqualTo(4)
  }

  @Test
  fun `solve1 -- input -- returns expected value`() {
    val result = day().solve1("$day/input.txt")

    assertThat(result).isEqualTo(111266)
  }

  @Test
  fun `solve2 -- test file 2 -- returns expected value`() {
    val result = day().solve2("$day/test1.txt")

    assertThat(result).isEqualTo("#3")
  }

  @Test
  fun `solve2 -- input -- returns expected value`() {
    val result = day().solve2("$day/input.txt")

    assertThat(result).isEqualTo("#266")
  }

  private fun day(): Day4 {
    return Day4()
  }
}