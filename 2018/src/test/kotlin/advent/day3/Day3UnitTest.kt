package advent.day3

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Day3UnitTest {

  @Test
  fun `solve1 -- test 1 -- returns expected value`() {
    val result = day(8 to 8).solve1("day3/test1.txt")

    assertThat(result).isEqualTo(4)
  }

  @Test
  fun `solve1 -- input -- returns expected value`() {
    val result = day().solve1("day3/input.txt")

    assertThat(result).isEqualTo(111266)
  }

  @Test
  fun `solve2 -- test file 2 -- returns expected value`() {
    val result = day().solve2("day3/test2.txt")

    assertThat(result).isEqualTo("fgij")
  }

  @Test
  fun `solve2 -- input -- returns expected value`() {
    val result = day().solve2("day3/input.txt")

    assertThat(result).isEqualTo("qyzphxoiseldjrntfygvdmanu")
  }

  private fun day(size: Pair<Int, Int> = 1_000 to 1_000): Day3 {
    return Day3(size)
  }
}