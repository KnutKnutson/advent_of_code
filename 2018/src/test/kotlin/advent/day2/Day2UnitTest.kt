package advent.day2

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Day2UnitTest {

  @Test
  fun `solve1 -- test file 1 -- returns expected value`() {
    val result = day().solve1("day2/test1.txt")

    assertThat(result).isEqualTo(12)
  }

  @Test
  fun `solve1 -- input -- returns expected value`() {
    val result = day().solve1("day2/day2input.txt")

    assertThat(result).isEqualTo(5478)
  }

  @Test
  fun `solve2 -- test file 2 -- returns expected value`() {
    val result = day().solve2("day2/test2.txt")

    assertThat(result).isEqualTo("fgij")
  }

  @Test
  fun `solve2 -- input -- returns expected value`() {
    val result = day().solve2("day2/day2input.txt")

    assertThat(result).isEqualTo("qyzphxoiseldjrntfygvdmanu")
  }

  private fun day(): Day2 {
    return Day2()
  }
}