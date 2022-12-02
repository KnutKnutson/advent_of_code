package com.knutknut.advent.twenty

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Day2UnitTest {
  @Test
  fun `solvePart1 -- example input -- returns expected`() {
    val input = TestUtil.loadResource("day2-part1-example.txt")

    val day2 = Day2().solvePart1(input)

    assertThat(day2).isEqualTo(15)
  }

  @Test
  fun solvePart1() {
    val input = TestUtil.loadResource("day2-part1-input.txt")

    val day2 = Day2().solvePart1(input)

    assertThat(day2).isEqualTo(13_809)
  }

  @Test
  fun `solvePart2 -- example input -- returns expected`() {
    val input = TestUtil.loadResource("day2-part1-example.txt")

    val day2 = Day2().solvePart2(input)

    assertThat(day2).isEqualTo(12)
  }

  @Test
  fun solvePart2() {
    val input = TestUtil.loadResource("day2-part1-input.txt")

    val day2 = Day2().solvePart2(input)

    assertThat(day2).isEqualTo(12_316)
  }
}