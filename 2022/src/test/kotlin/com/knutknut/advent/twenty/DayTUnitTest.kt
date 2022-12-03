package com.knutknut.advent.twenty

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class DayTUnitTest {
  @Test
  fun `solvePart1 -- example input -- returns correct answer`() {
    val input = TestUtil.loadResource("dayT-part1-example.txt")

    val solution = DayT().solvePart1(input)

    assertThat(solution).isEqualTo(24_000)
  }

  @Test
  fun solvePart1() {
    val input = TestUtil.loadResource("dayT-part1-input.txt")

    val solution = DayT().solvePart1(input)

    assertThat(solution).isEqualTo(69_626)
  }

  @Test
  fun `solvePart2 -- example input -- returns correct answer`() {
    val input = TestUtil.loadResource("dayT-part1-example.txt")

    val solution = DayT().solvePart2(input)

    assertThat(solution).isEqualTo(45_000)
  }

  @Test
  fun solvePart2() {
    val input = TestUtil.loadResource("dayT-part1-input.txt")

    val solution = DayT().solvePart2(input)

    assertThat(solution).isEqualTo(206_780)
  }
}