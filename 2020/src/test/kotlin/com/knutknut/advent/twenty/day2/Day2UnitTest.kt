package com.knutknut.advent.twenty.day2

import com.knutknut.advent.twenty.TestUtil
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Day2UnitTest {
  @Test
  fun `solve1 -- password at lowerbound of range -- matches`() {
    val policy = PasswordPolicy(lowerBound = 1, upperBound = 3, letter = 'a')
    val password = Password("abc", policy)

    val answer = Day2().solve1(listOf(password))

    assertThat(answer).isEqualTo(1)
  }

  @Test
  fun `solve1 -- password at upperbound of range -- matches`() {
    val policy = PasswordPolicy(lowerBound = 1, upperBound = 3, letter = 'a')
    val password = Password("aaabc", policy)

    val answer = Day2().solve1(listOf(password))

    assertThat(answer).isEqualTo(1)
  }

  @Test
  fun `solve1 -- password below lowerbound of range -- no match`() {
    val policy = PasswordPolicy(lowerBound = 1, upperBound = 3, letter = 'a')
    val password = Password("bbc", policy)

    val answer = Day2().solve1(listOf(password))

    assertThat(answer).isEqualTo(0)
  }

  @Test
  fun `solve1 -- password above upperbound of range -- no match`() {
    val policy = PasswordPolicy(lowerBound = 1, upperBound = 3, letter = 'a')
    val password = Password("aaaabc", policy)

    val answer = Day2().solve1(listOf(password))

    assertThat(answer).isEqualTo(0)
  }

  @Test
  fun solve1() {
    val passwordLines = TestUtil.loadResource("day2-part1-input.txt")
    val passwords = passwordLines.map(::lineToPassword)

    val answer = Day2().solve1(passwords)

    assertThat(answer).isEqualTo(538)
  }

  @Test
  fun solve2() {
    val passwordLines = TestUtil.loadResource("day2-part1-input.txt")
    val passwords = passwordLines.map(::lineToPassword)

    val answer = Day2().solve2(passwords)

    assertThat(answer).isEqualTo(489)
  }

  private fun lineToPassword(s: String): Password {
    val (range, letter, password) = s.split(" ")
    val (lower, upper) = range.split("-")
    return Password(
      password = password,
      policy = PasswordPolicy(
        lowerBound = lower.toInt(),
        upperBound = upper.toInt(),
        letter = letter.first()
      )
    )
  }
}