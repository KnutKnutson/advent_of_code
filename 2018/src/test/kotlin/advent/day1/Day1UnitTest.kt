package advent.day1

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Day1UnitTest {
  @Test
  fun `resolveFrequency -- test file 1 -- returns expected frequency`() {
    val result = day1().resolveFrequency("day1/test1.txt")

    assertThat(result).isEqualTo(0)
  }

  @Test
  fun `resolveFrequency -- test file 2 -- returns expected frequency`() {
    val result = day1().resolveFrequency("day1/test2.txt")

    assertThat(result).isEqualTo(6)
  }

  @Test
  fun `resolveFrequency -- actual input -- returns expected frequency`() {
    val result = day1().resolveFrequency("day1/day1Input.txt")

    assertThat(result).isEqualTo(578)
  }

  @Test
  fun `duplicateFrequency -- test file 3 -- returns first duplicated frequency`() {
    val result = day1().duplicateFrequency("day1/test3.txt")

    assertThat(result).isEqualTo(0)
  }

  @Test
  fun `duplicateFrequency -- test file 4 -- returns first duplicated frequency`() {
    val result = day1().duplicateFrequency("day1/test4.txt")

    assertThat(result).isEqualTo(14)
  }

  @Test
  fun `duplicateFrequency -- actual -- returns first duplicated frequency`() {
    val result = day1().duplicateFrequency("day1/day1Input.txt")

    assertThat(result).isEqualTo(82516)
  }

  private fun day1(): Day1 {
    return Day1()
  }
}