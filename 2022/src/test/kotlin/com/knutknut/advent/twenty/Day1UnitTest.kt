package com.knutknut.advent.twenty

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Day1UnitTest {
  @Test
  fun `solvePart1 -- example input -- returns 24000`() {
    val input = TestUtil.loadResource("day1-part1-example.txt")

    val day1 = Day1().solvePart1(input)

    assertThat(day1).isEqualTo(24_000)
  }

  @Test
  fun solvePart1() {
    val input = TestUtil.loadResource("day1-part1-input.txt")

    val day1 = Day1().solvePart1(input)

    assertThat(day1).isEqualTo(69_626)
  }

  @Test
  fun `solvePart2 -- example input -- returns 45000`() {
    val input = TestUtil.loadResource("day1-part1-example.txt")

    val day1 = Day1().solvePart2(input)

    assertThat(day1).isEqualTo(45_000)
  }

  @Test
  fun solvePart2() {
    val input = TestUtil.loadResource("day1-part1-input.txt")

    val day1 = Day1().solvePart2(input)

    assertThat(day1).isEqualTo(206_780)
  }
}