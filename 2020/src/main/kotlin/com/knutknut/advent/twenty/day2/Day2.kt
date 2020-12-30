package com.knutknut.advent.twenty.day2

class Day2 {
  fun solve1(passwords: List<Password>): Int {
    return passwords.count { it.isValid() }
  }

  fun solve2(passwords: List<Password>): Int {
    return passwords.count { it.isValid2() }
  }
}

data class Password(
  val password: String,
  val policy: PasswordPolicy
) {
  fun isValid(): Boolean = policy.matches(password)
  fun isValid2(): Boolean = policy.matches2(password)
}

data class PasswordPolicy(
  val lowerBound: Int,
  val upperBound: Int,
  val letter: Char
) {
  fun matches(s: String): Boolean {
    return (lowerBound..upperBound).contains(s.count { it == letter })
  }

  fun matches2(s: String): Boolean {
    return (s[lowerBound - 1] == letter) xor (s[upperBound - 1] == letter)
  }
}