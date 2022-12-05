package com.knutknut.advent.twenty

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Day5UnitTest {
  @Test
  fun `solvePart1 -- example input -- returns correct answer`() {
    val input = TestUtil.loadResource("day5-part1-example.txt")

    val solution = Day5().solvePart1(input, 3)

    assertThat(solution).isEqualTo("CMZ")
  }

  @Test
  fun solvePart1() {
    val input = TestUtil.loadResource("day5-part1-input.txt")

    val solution = Day5().solvePart1(input, 9)

    assertThat(solution).isEqualTo("QMBMJDFTD")
  }

  @Test
  fun `solvePart2 -- example input -- returns correct answer`() {
    val input = TestUtil.loadResource("day5-part1-example.txt")

    val solution = Day5().solvePart2(input, 3)

    assertThat(solution).isEqualTo("MCD")
  }

  @Test
  fun solvePart2() {
    val input = TestUtil.loadResource("day5-part1-input.txt")

    val solution = Day5().solvePart2(input, 9)

    assertThat(solution).isEqualTo("NBTVTJNFJ")
  }
}