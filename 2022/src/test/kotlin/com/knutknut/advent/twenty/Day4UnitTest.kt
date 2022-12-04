package com.knutknut.advent.twenty

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Day4UnitTest {
  @Test
  fun `solvePart1 -- example input -- returns correct answer`() {
    val input = TestUtil.loadResource("day4-part1-example.txt")

    val solution = Day4().solvePart1(input)

    assertThat(solution).isEqualTo(2)
  }

  @Test
  fun `solvePart1 -- moar test input -- returns correct answer`() {
    val input = listOf("2-3,2-3")

    val solution = Day4().solvePart1(input)

    assertThat(solution).isEqualTo(1)
  }

  @Test
  fun solvePart1() {
    val input = TestUtil.loadResource("day4-part1-input.txt")

    val solution = Day4().solvePart1(input)

    assertThat(solution).isEqualTo(453)
  }

  @Test
  fun `solvePart2 -- example input -- returns correct answer`() {
    val input = TestUtil.loadResource("day4-part1-example.txt")

    val solution = Day4().solvePart2(input)

    assertThat(solution).isEqualTo(4)
  }

  @Test
  fun solvePart2() {
    val input = TestUtil.loadResource("day4-part1-input.txt")

    val solution = Day4().solvePart2(input)

    assertThat(solution).isEqualTo(919)
  }
}