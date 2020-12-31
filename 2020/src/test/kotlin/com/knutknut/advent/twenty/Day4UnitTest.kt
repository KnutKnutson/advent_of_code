package com.knutknut.advent.twenty

import com.knutknut.advent.twenty.day3.Day3
import com.knutknut.advent.twenty.day3.Point
import com.knutknut.advent.twenty.day3.Slope
import com.knutknut.advent.twenty.day3.TreeLine
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Day4UnitTest {
  @Test
  fun solve1() {
    val passports = loadPassports()

    val answer = Day4().solve1(passports)

    assertThat(answer).isEqualTo(242)
  }

  @Test
  fun solve2() {
    val passports = loadPassports()

    val answer = Day4().solve2(passports)

    assertThat(answer).isEqualTo(186)
  }

  private fun loadPassports(): List<Passport> {
    val lines = TestUtil.loadResource("day4-part1-input.txt")
    val passports = mutableListOf<Passport>()
    var passport = Passport()
    for (line in lines) {
      if (line.isBlank()) {
        passports.add(passport)
        passport = Passport()
        continue
      }
      line.split(" ").forEach { passInfo ->
        val (key, value) = passInfo.split(":")
        when(key) {
          "byr" -> passport.birthYear = value
          "iyr" -> passport.issueYear = value
          "eyr" -> passport.expirationYear = value
          "hgt" -> passport.height = value
          "hcl" -> passport.hairColor = value
          "ecl" -> passport.eyeColor = value
          "pid" -> passport.passportId = value
          "cid" -> passport.countryId = value
        }
      }
    }
    passports.add(passport)
    return passports
  }
}