package com.knutknut.advent.twenty

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Day6UnitTest {
  @Test
  fun `solvePart1 -- example 1 input -- returns correct answer`() {
    val input = "mjqjpqmgbljsphdztnvjfqwrcgsmlb"

    val solution = Day6().solvePart1(input)

    assertThat(solution).isEqualTo(7)
  }

  @Test
  fun `solvePart1 -- example 2 input -- returns correct answer`() {
    val input = "bvwbjplbgvbhsrlpgdmjqwftvncz"

    val solution = Day6().solvePart1(input)

    assertThat(solution).isEqualTo(5)
  }

  @Test
  fun `solvePart1 -- example 3 input -- returns correct answer`() {
    val input = "nppdvjthqldpwncqszvftbrmjlhg"

    val solution = Day6().solvePart1(input)

    assertThat(solution).isEqualTo(6)
  }

  @Test
  fun `solvePart1 -- example 4 input -- returns correct answer`() {
    val input = "nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg"

    val solution = Day6().solvePart1(input)

    assertThat(solution).isEqualTo(10)
  }

  @Test
  fun `solvePart1 -- example 5 input -- returns correct answer`() {
    val input = "zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw"

    val solution = Day6().solvePart1(input)

    assertThat(solution).isEqualTo(11)
  }

  @Test
  fun solvePart1() {
    val input = TestUtil.loadResource("day6-part1-input.txt")[0]

    val solution = Day6().solvePart1(input)

    assertThat(solution).isEqualTo(1080)
  }

  @Test
  fun `solvePart2 -- example input -- returns correct answer`() {
    val input = "mjqjpqmgbljsphdztnvjfqwrcgsmlb"

    val solution = Day6().solvePart2(input)

    assertThat(solution).isEqualTo(19)
  }

  @Test
  fun solvePart2() {
    val input = TestUtil.loadResource("day6-part1-input.txt")[0]

    val solution = Day6().solvePart2(input)

    assertThat(solution).isEqualTo(3645)
  }
}