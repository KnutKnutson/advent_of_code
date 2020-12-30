package com.knutknut.advent.twenty

import com.knutknut.advent.twenty.day1.Day1
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Day1UnitTest {

  @Test
  fun solve() {
    val expenseReportLines = TestUtil.loadResource("day1-part1-input.txt")
    val expenseReport = expenseReportLines.map { it.toInt() }

    val day1 = Day1().solve(expenseReport)

    assertThat(day1).isEqualTo(703131)
  }

  @Test
  fun solve2() {
    val expenseReportLines = TestUtil.loadResource("day1-part1-input.txt")
    val expenseReport = expenseReportLines.map { it.toInt() }

    val day1 = Day1().solve2(expenseReport)

    assertThat(day1).isEqualTo(703131)
  }
}