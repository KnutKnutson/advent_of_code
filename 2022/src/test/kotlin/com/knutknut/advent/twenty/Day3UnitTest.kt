package com.knutknut.advent.twenty

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Day3UnitTest {
  @Test
  fun `solvePart1 -- example input -- returns correct answer`() {
    val input = TestUtil.loadResource("day3-part1-example.txt")

    val solution = Day3().solvePart1(input)

    assertThat(solution).isEqualTo(157)
  }

  @Test
  fun solvePart1() {
    val input = TestUtil.loadResource("day3-part1-input.txt")

    val solution = Day3().solvePart1(input)

    assertThat(solution).isEqualTo(7_581)
  }

  @Test
  fun `solvePart2 -- example input -- returns correct answer`() {
    val input = TestUtil.loadResource("day3-part1-example.txt")

    val solution = Day3().solvePart2(input)

    assertThat(solution).isEqualTo(70)
  }

  @Test
  fun solvePart2() {
    val input = TestUtil.loadResource("day3-part1-input.txt")

    val solution = Day3().solvePart2(input)

    assertThat(solution).isEqualTo(2_525)
  }
}