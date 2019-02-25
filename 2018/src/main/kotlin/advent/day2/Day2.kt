package advent.day2

import advent.Day

/**
 * --- Day 2: Inventory Management System ---
 */
class Day2: Day<Int, String?>() {

  override fun solve1(inputResource: String): Int {
    return resourceContents(inputResource).lines().fold(Counter(0, 0)) { c, s ->
      if (hasLetters(s, 2)) c.twoLetterCount++
      if (hasLetters(s, 3)) c.threeLetterCount++
      c
    }.let { it.threeLetterCount * it.twoLetterCount }
  }

  override fun solve2(inputResource: String): String? {
    val boxIds = resourceContents(inputResource).lines()
    boxIds.forEach { boxId ->
      boxIds.forEach { otherId ->
        val sameLetters = sameLetters(boxId, otherId)
        if (sameLetters.length == boxId.length - 1) return sameLetters
      }
    }
    return null
  }

  private fun hasLetters(s: String, count: Int): Boolean {
    return s.groupBy { it }.values.any { it.size == count }
  }

  private fun sameLetters(boxId: String, otherId: String): String {
    return boxId.filterIndexed { index, c -> otherId[index] == c }
  }

  data class Counter(var twoLetterCount: Int, var threeLetterCount: Int)
}