package advent.day2

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Day2UnitTest {

  @Test
  fun `resolveFrequency -- test file 1 -- returns expected frequency`() {
    val result = day().solve1("day2/test1.txt")

    assertThat(result).isEqualTo(12)
  }

  private fun day(): Day2 {
    return Day2()
  }
}