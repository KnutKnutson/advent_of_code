package com.knutknut.advent.twenty.day3

import com.knutknut.advent.twenty.TestUtil
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Day3UnitTest {
  @Test
  fun solve1() {
    val slope = loadSlope()

    val answer = Day3().solve1(slope)

    assertThat(answer).isEqualTo(209)
  }

  @Test
  fun solve2() {
    val slope = loadSlope()

    val answer = Day3().solve2(slope)

    assertThat(answer).isEqualTo(1574890240)
  }

  @Test
  fun `countTreesForSlope -- skipping treelines`() {
    val slope = Slope(
      treeLines = listOf(
        TreeLine(line = ".#".map { Point(it) }),
        TreeLine(line = "#.".map { Point(it) }),
        TreeLine(line = ".#".map { Point(it) }),
        TreeLine(line = "#.".map { Point(it) })
      )
    )

    val answer = Day3().countTreesForSlope(slope, 1, 2)

    assertThat(answer).isEqualTo(1)
  }

  private fun loadSlope(): Slope {
    val slopeLines = TestUtil.loadResource("day3-part1-input.txt")
    return Slope(
      treeLines = slopeLines.map { lineString ->
        TreeLine(line = lineString.map { Point(c = it) })
      }
    )
  }
}