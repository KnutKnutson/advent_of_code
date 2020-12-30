package com.knutknut.advent.twenty.day1

class Day1 {
  fun solve(expenseReport: List<Int>): Int {
    expenseReport.forEach { i ->
      expenseReport.forEach { ii ->
        if (i + ii == 2020) return i * ii
      }
    }
    throw Exception("This expense report isn't valid at all!")
  }

  fun solve2(expenseReport: List<Int>): Long {
    expenseReport.forEach { i ->
      expenseReport.forEach { ii ->
        expenseReport.forEach { iii ->
          if (i + ii + iii == 2020) return i * ii * iii.toLong()
        }
      }
    }
    throw Exception("This expense report isn't valid at all!")
  }
}